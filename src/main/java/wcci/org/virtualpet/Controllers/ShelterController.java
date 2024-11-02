package wcci.org.virtualpet.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.annotation.Resource;
import wcci.org.virtualpet.BOService.*;
import wcci.org.virtualpet.DTO.*;
import wcci.org.virtualpet.Enums.PetType;
import wcci.org.virtualpet.Exceptions.NotFoundException;
import wcci.org.virtualpet.Exceptions.ValidateException;
import wcci.org.virtualpet.Interfaces.PetInterface;

import java.util.*;

import org.slf4j.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



/**
 * Controller for managing shelter operations related to pets.
 * Provides RESTful APIs for pet admission, retrieval, updating, and actions
 * such as feeding, watering, and playing with pets.
 */
@RestController
@RequestMapping({ "/api/v1/shelter", "/api/v1/shelter/home", "/api/v1/shelter/pets" })
public class ShelterController {

    private final Logger logger = LoggerFactory.getLogger(ShelterController.class);

    @Resource
    private Populator populator;

    @Resource
    private DBService service;

    /**
     * Constructor for ShelterController.
     * 
     * @param service the DBService used for pet operations.
     */
    public ShelterController(DBService service) {
        this.service = service;
    }

    /**
     * Admits a new pet into the shelter.
     * 
     * @param entity the admission data for the pet.
     * @return a ResponseEntity with HTTP status NO_CONTENT.
     */
    @PostMapping
    public ResponseEntity<?> postMethodName(@RequestBody AdmissionDTO entity) throws ValidateException {
            PetInterface result = null;
            try {
                result = service.savePet(entity);
            }
            catch (ValidateException ve){
                entity.setErrorCode(1);
                entity.setErrorMessage(ve.getMessage());
                this.logger.error("Validation Error while saving " + entity, ve);
                throw ve;
            }
            catch (Exception ex) {
                entity.setErrorCode(2);
                entity.setErrorMessage(ex.getMessage());
                this.logger.error("Error while saving " + entity, ex);
                throw ex;
            }
            return ResponseEntity.ok(result);
    }




    

    /**
     * Retrieves a new admission DTO.
     * (This seems to return a new empty DTO; consider revising for practical use.)
     * 
     * @return a new AdmissionDTO.
     */
    @GetMapping("/admissions")
    public AdmissionDTO getMethodName() {
        return new AdmissionDTO();
    }

    /**
     * Updates an existing pet's information by ID.
     * 
     * @param id     the ID of the pet to update.
     * @param entity the data to update the pet with.
     * @return a ResponseEntity with HTTP status NO_CONTENT.
     */
    @PostMapping("/{id}")
    public ResponseEntity<Void> postMethodName(@PathVariable Long id, @RequestBody EditPetDTO entity) throws Exception {
        service.editPet(entity);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Placeholder method for processing a generic POST request.
     * 
     * @param entity the string data for processing.
     * @return the received string.
     */
    public String postMethodName(@RequestBody String entity) {
        // TODO: process POST request
        return entity;
    }

    /**
     * Retrieves all pets in the shelter.
     * 
     * @return a collection of all pets.
     */
    @GetMapping("/refresh")
    public void refreshData() throws Exception {
        populator.run(new String[0]);
    }

    @GetMapping
    public ResponseEntity<?> getAll() {
        ArrayList<PetInterface> results = new ArrayList<>();
        try {
            results = new ArrayList<>(service.getAll().values());
        } catch (Exception ex) {
            logger.error("Error getting pets: " + ex.getMessage());
            ErrorDataDTO errors = new ErrorDataDTO();
            errors.setErrorMessage(ex.getMessage());
            errors.setErrorCode(500);
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(results);
    }

    /**
     * Retrieves a pet by its ID.
     * 
     * @param id the ID of the pet to retrieve.
     * @return the pet with the specified ID.
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id) throws Exception {
        PetInterface result = null;
        try {
            result = service.getById(id);
        } 
        catch (Exception ex) {
            logger.error(ex.getMessage());
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return ResponseEntity.ok(result);
    }

    /**
     * Retrieves pets by their name.
     * 
     * @param name the name of the pets to retrieve.
     * @return a collection of pets with the specified name.
     */
    @GetMapping("/name/{name}")
    public Collection<PetInterface> getPetName(@PathVariable String name) throws Exception {
        return service.getByName(name).values();
    }

    /**
     * Retrieves pets by their type.
     * 
     * @param petType the type of pets to retrieve.
     * @return a collection of pets of the specified type.
     */
    @GetMapping("/pettype/{petType}")
    public Collection<PetInterface> getPetType(@PathVariable PetType petType) throws Exception {
        return service.getByPetType(petType).values();
    }

    /**
     * Removes a pet from the shelter by ID.
     * 
     * @param id the ID of the pet to remove.
     * @return a ResponseEntity indicating success or failure.
     * @throws NotFoundException 
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removePet(@PathVariable Long id) throws Exception {
        PetInterface pet = service.getById(id);
        if (pet != null) {
            service.removePet(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    /**
     * Feeds all pets in the shelter and removes any that are dead.
     * 
     * @return a collection of all pets after feeding.
     */
    @GetMapping("/feed")
    public Collection<StatusDTO> feedPet() throws Exception {
        ArrayList<StatusDTO> results = new ArrayList<>();
        Map<Long, PetInterface> map = service.getAll();
        for (PetInterface pet : map.values()) {
            pet.feed();
            if (pet.isDead()) {
                service.removePet(pet.getId());
            } else {
                service.updatePet(pet);
                StatusDTO status = new StatusDTO();
                status.setName(pet.getName());
                status.setPetType(pet.getPetType());
                status.setStatus("This pet has been fed.");
                status.setValue(pet.getStatus());
                results.add(status);
            }
        }
        return results;
    }

    @GetMapping("/feed/{id}")
    public StatusDTO feedAPet(@PathVariable long id) throws Exception {
        StatusDTO status = new StatusDTO();
        PetInterface pet = service.getById(id);
            pet.feed();
            if (pet.isDead()) {
                service.removePet(pet.getId());
            } else {
                service.updatePet(pet);
                status.setName(pet.getName());
                status.setPetType(pet.getPetType());
                status.setStatus("This pet has been fed.");
                status.setValue(pet.getStatus());
            }
        return status;
    }

    @GetMapping("/water/{id}")
    public StatusDTO waterAPet(@PathVariable long id) throws Exception {
        StatusDTO status = new StatusDTO();
        PetInterface pet = service.getById(id);
            pet.water();
            if (pet.isDead()) {
                service.removePet(pet.getId());
            } else {
                service.updatePet(pet);
                status.setName(pet.getName());
                status.setPetType(pet.getPetType());
                status.setStatus("This pet has been watered.");
                status.setValue(pet.getStatus());
            }
        return status;
    }

    @GetMapping("/play/{id}")
    public StatusDTO playWithAPet(@PathVariable long id) throws Exception {
        StatusDTO status = new StatusDTO();
        PetInterface pet = service.getById(id);
            pet.play();
            if (pet.isDead()) {
                service.removePet(pet.getId());
            } else {
                service.updatePet(pet);
                status.setName(pet.getName());
                status.setPetType(pet.getPetType());
                status.setStatus("This pet enjoyed playing.");
                status.setValue(pet.getStatus());
            }
        return status;
    }

    @GetMapping("/heal/{id}")
    public StatusDTO healAPet(@PathVariable long id) throws Exception {
        StatusDTO status = new StatusDTO();
        PetInterface pet = service.getById(id);
            pet.heal();
            if (pet.isDead()) {
                service.removePet(pet.getId());
            } else {
                service.updatePet(pet);
                status.setName(pet.getName());
                status.setPetType(pet.getPetType());
                status.setStatus("This pet has been healed.");
                status.setValue(pet.getStatus());
            }
        return status;
    }
    

    /**
     * Waters all pets in the shelter and removes any that are dead.
     * 
     * @return a collection of all pets after watering.
     */
    @GetMapping("/water")
    public ArrayList<StatusDTO> waterPet() throws Exception {
        ArrayList<StatusDTO> results = new ArrayList<>();
        Map<Long, PetInterface> map = service.getAll();
        for (PetInterface pet : map.values()) {
            pet.water();
            if (pet.isDead()) {
                service.removePet(pet.getId());
            } else {
                service.updatePet(pet);
                StatusDTO status = new StatusDTO();
                status.setName(pet.getName());
                status.setPetType(pet.getPetType());
                status.setStatus("This pet has been given water.");
                status.setValue(pet.getStatus());
                results.add(status);
            }
        }
        return results;
    }

    /**
     * Plays with all pets in the shelter and removes any that are dead.
     * 
     * @return a collection of all pets after playing.
     */
    @GetMapping("/play")
    public ArrayList<StatusDTO> playPet() throws Exception {
        ArrayList<StatusDTO> results = new ArrayList<>();
        Map<Long, PetInterface> map = service.getAll();
        for (PetInterface pet : map.values()) {
            pet.play();
            if (pet.isDead()) {
                service.removePet(pet.getId());
            } else {
                service.updatePet(pet);
                StatusDTO status = new StatusDTO();
                status.setName(pet.getName());
                status.setPetType(pet.getPetType());
                status.setStatus("This pet has been given water.");
                status.setValue(pet.getStatus());
                results.add(status);
            }
        }
        return results;
    }



    /**
     * Heals all pets in the shelter and removes any that are dead.
     * 
     * @return a collection of all pets after healing.
     */
    @GetMapping("/heal")
    public ArrayList<StatusDTO> healPet() throws Exception {
        ArrayList<StatusDTO> results = new ArrayList<>();
        Map<Long, PetInterface> map = service.getAll();
        for (PetInterface pet : map.values()) {
            pet.heal();
            if (pet.isDead()) {
                service.removePet(pet.getId());
            } else {
                service.updatePet(pet);
                StatusDTO status = new StatusDTO();
                status.setName(pet.getName());
                status.setPetType(pet.getPetType());
                status.setStatus("This pet has been healed.");
                status.setValue(pet.getStatus());
                results.add(status);
            }
        }
        return results;
    }

    /**
     * Retrieves the speaking abilities of all pets.
     * 
     * @return a collection of SpeakDTO containing the pets' speaking information.
     */
    @GetMapping("/speak")
    public Collection<SpeakDTO> speakPet() throws Exception {
        List<SpeakDTO> pets = new ArrayList<>();
        Map<Long, PetInterface> map = service.getAll();
        for (PetInterface pet : map.values()) {
            pets.add(new SpeakDTO(pet.getPetType(), pet.getName(), pet.speak()));
        }
        return pets;
    }

    /**
     * Retrieves the health status of all pets.
     * 
     * @return a collection of HealthDTO containing the pets' health information.
     */
    @GetMapping("/health")
    public Collection<HealthDTO> healthPet() throws Exception {
        List<HealthDTO> pets = new ArrayList<>();
        Map<Long, PetInterface> map = service.getAll();
        for (PetInterface pet : map.values()) {
            pets.add(new HealthDTO(pet.getPetType(), pet.getName(), pet.checkHealth()));
        }
        return pets;
    }

    /**
     * Retrieves the happiness levels of all pets.
     * 
     * @return a collection of HappinessDTO containing the pets' happiness
     *         information.
     */
    @GetMapping("/happiness")
    public Collection<HappinessDTO> happinessPet() throws Exception {
        List<HappinessDTO> pets = new ArrayList<>();
        Map<Long, PetInterface> map = service.getAll();
        for (PetInterface pet : map.values()) {
            pets.add(new HappinessDTO(pet.getPetType(), pet.getName(), pet.checkHappiness()));
        }
        return pets;
    }

    /**
     * Simulates the passage of time for all pets, updating their status.
     * Removes any pets that are dead.
     */

}
