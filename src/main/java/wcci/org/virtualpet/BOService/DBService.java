package wcci.org.virtualpet.BOService;

import java.util.*;

import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import wcci.org.virtualpet.DTO.AdmissionDTO;
import wcci.org.virtualpet.DTO.EditPetDTO;
import wcci.org.virtualpet.Enums.*;
import wcci.org.virtualpet.Exceptions.NotFoundException;
import wcci.org.virtualpet.Exceptions.ValidateException;
import wcci.org.virtualpet.Interfaces.PetInterface;
import wcci.org.virtualpet.Models.*;
import wcci.org.virtualpet.Repositories.*;

/**
 * Service class for handling operations related to pets in the database.
 * Provides methods for saving, retrieving, updating, and removing pets.
 */
@Service
public class DBService {

    @Resource
    private CatRepository cats;

    @Resource
    private DogRepository dogs;

    @Resource
    private RoboCatRepository roboCats;

    @Resource
    private RoboDogRepository roboDogs;

    /**
     * Constructor for initializing the repositories for each pet type.
     * 
     * @param cats the repository for CatModel objects
     * @param dogs the repository for DogModel objects
     * @param roboCats the repository for RoboCatModel objects
     * @param roboDogs the repository for RoboDogModel objects
     */
    public DBService(CatRepository cats, DogRepository dogs, RoboCatRepository roboCats, RoboDogRepository roboDogs) {
        this.cats = cats;
        this.dogs = dogs;
        this.roboCats = roboCats;
        this.roboDogs = roboDogs;
    }

    /**
     * Saves a pet based on the provided admission information.
     * 
     * @param admissions the data transfer object containing information about the pet to admit
     */
    public PetInterface savePet(AdmissionDTO admissions) throws ValidateException {
        PetInterface result = null;
        switch (admissions.getPetType()) {
            case Dog: {
                DogModel model = new DogModel(admissions.getName(), admissions.getAge());
                result = dogs.save(model);
                break;
            }
            case Cat: {
                CatModel model = new CatModel(admissions.getName(), admissions.getAge());
                result = cats.save(model);
                break;
            }
            case RoboDog: {
                RoboDogModel model = new RoboDogModel(admissions.getName(), admissions.getAge());
                result = roboDogs.save(model);
                break;
            }
            case RoboCat: {
                RoboCatModel model = new RoboCatModel(admissions.getName(), admissions.getAge());
                result = roboCats.save(model);
                break;
            }
        }
        return result;
    }

    /**
     * Retrieves all pets of every type from the database.
     * 
     * @return a map where the keys are the pet IDs and the values are the pet objects
     */
    public Map<Long, PetInterface> getAll() {
        HashMap<Long, PetInterface> map = new HashMap<>();
        for (PetType petType : PetType.values()) {
            switch (petType) {
                case Dog: {
                    List<DogModel> dogRepo = dogs.findAll();
                    for (DogModel dog : dogRepo) {
                        map.put(dog.getId(), dog);
                    }
                    break;
                }
                case Cat: {
                    List<CatModel> catRepo = cats.findAll();
                    for (CatModel cat : catRepo) {
                        map.put(cat.getId(), cat);
                    }
                    break;
                }
                case RoboDog: {
                    List<RoboDogModel> RoboDogRepo = roboDogs.findAll();
                    for (RoboDogModel roboDog : RoboDogRepo) {
                        map.put(roboDog.getId(), roboDog);
                    }
                    break;
                }
                case RoboCat: {
                    List<RoboCatModel> RoboCatRepo = roboCats.findAll();
                    for (RoboCatModel roboCat : RoboCatRepo) {
                        map.put(roboCat.getId(), roboCat);
                    }
                    break;
                }
                default:
                    break;
            }
        }
        return map;
    }

    /**
     * Retrieves a pet by its ID.
     * 
     * @param id the ID of the pet to retrieve
     * @return the pet object if found
     * @throws NotFoundException if the pet with the given ID is not found
     */
    public PetInterface getById(long id) throws NotFoundException {
        PetInterface result = null;

        // Search for Cat
        Optional<CatModel> optCat = cats.findById(id);
        if (!optCat.isEmpty()) {
            result = optCat.get();
        }

        // Search for Dog if not found as Cat
        if (result == null) {
            Optional<DogModel> optDog = dogs.findById(id);
            if (!optDog.isEmpty()) {
                result = optDog.get();
            }
        }

        // Search for RoboDog if not found as Dog
        if (result == null) {
            Optional<RoboDogModel> optRoboDog = roboDogs.findById(id);
            if (!optRoboDog.isEmpty()) {
                result = optRoboDog.get();
            }
        }

        // Search for RoboCat if not found as RoboDog
        if (result == null) {
            Optional<RoboCatModel> optRoboCat = roboCats.findById(id);
            if (!optRoboCat.isEmpty()) {
                result = optRoboCat.get();
            }
        }

        // Throw exception if no pet was found
        if (result == null) {
            throw new NotFoundException(id);
        }

        return result;
    }

    /**
     * Retrieves pets by name, using a case-insensitive search.
     * 
     * @param name the name or part of the name of the pet
     * @return a map of pets matching the name, with the pet ID as the key and the pet object as the value
     */
    public Map<Long, PetInterface> getByName(String name) {
        HashMap<Long, PetInterface> result = new HashMap<>();
        for (PetType petType : PetType.values()) {
            switch (petType) {
                case Dog: {
                    List<DogModel> dogRepo = dogs.findByNameContainingIgnoreCase(name);
                    for (DogModel dog : dogRepo) {
                        result.put(dog.getId(), dog);
                    }
                    break;
                }
                case Cat: {
                    List<CatModel> catRepo = cats.findByNameContainingIgnoreCase(name);
                    for (CatModel cat : catRepo) {
                        result.put(cat.getId(), cat);
                    }
                    break;
                }
                case RoboDog: {
                    List<RoboDogModel> RoboDogRepo = roboDogs.findByNameContainingIgnoreCase(name);
                    for (RoboDogModel roboDog : RoboDogRepo) {
                        result.put(roboDog.getId(), roboDog);
                    }
                    break;
                }
                case RoboCat: {
                    List<RoboCatModel> RoboCatRepo = roboCats.findByNameContainingIgnoreCase(name);
                    for (RoboCatModel roboCat : RoboCatRepo) {
                        result.put(roboCat.getId(), roboCat);
                    }
                    break;
                }
                default:
                    break;
            }
        }
        return result;
    }

    /**
     * Retrieves pets by type.
     * 
     * @param petType the type of pet (Dog, Cat, RoboDog, RoboCat)
     * @return a map of pets of the given type, with the pet ID as the key and the pet object as the value
     */
    public Map<Long, PetInterface> getByPetType(PetType petType) {
        HashMap<Long, PetInterface> result = new HashMap<>();
        switch (petType) {
            case Dog: {
                List<DogModel> dogRepo = dogs.findAll();
                for (DogModel dog : dogRepo) {
                    result.put(dog.getId(), dog);
                }
                break;
            }
            case Cat: {
                List<CatModel> catRepo = cats.findAll();
                for (CatModel cat : catRepo) {
                    result.put(cat.getId(), cat);
                }
                break;
            }
            case RoboDog: {
                List<RoboDogModel> RoboDogRepo = roboDogs.findAll();
                for (RoboDogModel roboDog : RoboDogRepo) {
                    result.put(roboDog.getId(), roboDog);
                }
                break;
            }
            case RoboCat: {
                List<RoboCatModel> RoboCatRepo = roboCats.findAll();
                for (RoboCatModel roboCat : RoboCatRepo) {
                    result.put(roboCat.getId(), roboCat);
                }
                break;
            }
            default:
                break;
        }
        return result;
    }

    /**
     * Updates an existing pet in the database.
     * 
     * @param pet the pet object containing updated information
     */
    public void updatePet(PetInterface pet) {
        PetType petType = pet.getPetType();
        switch (petType) {
            case Dog: {
                dogs.save((DogModel) pet);
                break;
            }
            case Cat: {
                cats.save((CatModel) pet);
                break;
            }
            case RoboDog: {
                roboDogs.save((RoboDogModel) pet);
                break;
            }
            case RoboCat: {
                roboCats.save((RoboCatModel) pet);
                break;
            }
            default:
                break;
        }
    }

    /**
     * Edits a pet's details based on the provided EditPetDTO object.
     * 
     * @param editPet the data transfer object containing updated pet information
     * @throws Exception if the pet is not found or cannot be updated
     */
    public void editPet(EditPetDTO editPet) throws Exception {
        PetInterface pet = getById(editPet.getId());
        switch (pet.getPetType()) {
            case Dog: {
                dogs.save((DogModel) pet);
                break;
            }
            case Cat: {
                cats.save((CatModel) pet);
                break;
            }
            case RoboDog: {
                roboDogs.save((RoboDogModel) pet);
                break;
            }
            case RoboCat: {
                roboCats.save((RoboCatModel) pet);
                break;
            }
            default:
                break;
        }
    }

    /**
     * Removes a pet from the database by its ID.
     * 
     * @param id the ID of the pet to remove
     * @throws Exception if the pet is not found
     */
    public void removePet(Long id) throws Exception {
        PetInterface pet = getById(id);
        if (pet != null) {
            PetType petType = pet.getPetType();
            switch (petType) {
                case Dog: {
                    dogs.delete((DogModel) pet);
                    break;
                }
                case Cat: {
                    cats.delete((CatModel) pet);
                    break;
                }
                case RoboDog: {
                    roboDogs.delete((RoboDogModel) pet);
                    break;
                }
                case RoboCat: {
                    roboCats.delete((RoboCatModel) pet);
                    break;
                }
                default:
                    break;
            }
        }
    }
}
