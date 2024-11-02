package wcci.org.virtualpet.Models;

import jakarta.persistence.Entity;
import wcci.org.virtualpet.Enums.PetType;
import wcci.org.virtualpet.Exceptions.ValidateException;

/**
 * Represents a Cat in the virtual pet system. This class extends the {@link PetModel}
 * and provides cat-specific behavior such as speaking and retrieving status.
 */
@Entity
public class CatModel extends PetModel {

    /**
     * Default no-argument constructor for JPA (Java Persistence API).
     * Used when retrieving the cat entity from the database.
     */
    public CatModel() {
        super();
    }

    /**
     * Constructs a new CatModel with the specified name and age.
     * 
     * @param name the name of the cat
     * @param age the age of the cat
     * @throws ValidateException 
     */
    public CatModel(String name, int age) throws ValidateException {
        super(PetType.Cat, name, age); // PetModel is the superclass
    }

    /**
     * Returns the sound the cat makes, which depends on its happiness level.
     * If the cat is dead, it makes no sound. If happiness is low, the cat growls.
     * Otherwise, it either purrs or meows depending on happiness.
     * 
     * @return the sound the cat makes as a String
     */
    @Override
    public String speak() {
        if (isDead()) {
            return "The cat is dead. Nothing happens.";
        } else if (getHappiness() < 20) {
            return "Grrrrr";
        } else if (getHappiness() >= 50) {
            return "Pur";
        } else {
            return "Meow";
        }
    }

    /**
     * Returns a summary of the cat's current status, including hunger, happiness,
     * health, and thirst levels.
     * 
     * @return the cat's status as a formatted String
     */
    @Override
    public String getStatus() {
        String results = "Hunger: " + getHunger() + "% || ";
        results += "Thirst: " + getThirst() + "% || ";
        results += "Happiness: " + getHappiness() + "% || ";
        results += "Health: " + getHealth() + "%.";
        return results;
    }
}
