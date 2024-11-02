package wcci.org.virtualpet.Interfaces;

import wcci.org.virtualpet.Enums.PetType;

/**
 * The PetInterface defines the contract for all types of pets in the system.
 * It includes methods for managing the pet's basic attributes (ID, name, type),
 * as well as operations related to the pet's well-being (feeding, watering, playing, etc.).
 */
public interface PetInterface {
    
    /**
     * Retrieves the unique identifier of the pet.
     * 
     * @return the pet's ID as a long value
     */
    long getId();
    
    /**
     * Retrieves the type of the pet (e.g., Dog, Cat, RoboDog, RoboCat).
     * 
     * @return the {@link PetType} of the pet
     */
    PetType getPetType();
    
    /**
     * Retrieves the name of the pet.
     * 
     * @return the pet's name as a String
     */
    String getName();
    
    /**
     * Feeds the pet. The specific implementation of how the pet is fed
     * depends on the type of pet.
     */
    void feed();
    
    /**
     * Waters the pet. Ensures the pet is hydrated. The exact effect
     * depends on the specific type of pet.
     */
    void water();
    
    /**
     * Heals the pet. Used to restore the pet's health after illness or injury.
     */
    void heal();
    
    /**
     * Plays with the pet. This method increases the pet's happiness level.
     */
    void play();
    
    /**
     * Makes the pet speak. Returns a sound or phrase specific to the pet's type.
     * 
     * @return the sound or phrase the pet makes as a String
     */
    String speak();
    
    /**
     * Simulates the passage of time for the pet. The effects of time on
     * the pet's health, happiness, or other attributes are managed within this method.
     */
    void passageOfTime();
    
    /**
     * Checks if the pet is dead. This method is used to determine if the pet's
     * health has deteriorated to a fatal state.
     * 
     * @return true if the pet is dead, false otherwise
     */
    boolean isDead();
    
    /**
     * Checks the health of the pet. Provides a string describing the pet's health status.
     * 
     * @return a description of the pet's health as a String
     */
    String checkHealth();
    
    /**
     * Checks the happiness of the pet. Provides a string describing the pet's current happiness level.
     * 
     * @return a description of the pet's happiness as a String
     */
    String checkHappiness();
    
    /**
     * Retrieves the overall status of the pet, including health, happiness, and other factors.
     * 
     * @return a comprehensive status of the pet as a String
     */
    String getStatus();
}
