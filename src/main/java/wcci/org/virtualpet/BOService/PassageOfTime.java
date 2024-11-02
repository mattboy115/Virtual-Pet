package wcci.org.virtualpet.BOService;

import java.util.Map;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import wcci.org.virtualpet.Interfaces.PetInterface;

// @Service 
public class PassageOfTime {
    private final Logger logger = LoggerFactory.getLogger(PassageOfTime.class);

    @Autowired
    private DBService service;

    @Scheduled(fixedDelay = 90000)
    public void performTask() {
        try {
            passageOfTime();
        }
        catch (Exception ex) {
            logger.error("Error processing passage of time.", ex);
        }
    }

    private void passageOfTime() {
        Map<Long, PetInterface> map = service.getAll();
        for (PetInterface pet : map.values()) {
            try {
                pet.passageOfTime();
                if (pet.isDead()) {
                    logger.info("Pet has died: " + pet.toString());
                    service.removePet(pet.getId());
                }
                else {
                    service.updatePet(pet);
                }
            }
            catch (Exception ex) {
                logger.error("Error processing passage of time for pet: " + pet.toString(), ex);
            }
        }
    }
}
