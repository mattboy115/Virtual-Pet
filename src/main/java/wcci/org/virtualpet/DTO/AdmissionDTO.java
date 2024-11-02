package wcci.org.virtualpet.DTO;

import wcci.org.virtualpet.Enums.PetType;

/**
 * Data Transfer Object (DTO) for admitting a new pet to the system.
 * This class contains information about the pet such as name, age, and type.
 * It extends the {@link ErrorDataDTO} to handle any potential error data.
 */
public class AdmissionDTO extends ErrorDataDTO {
    private String name;
    private Integer age;
    private PetType petType;

    /**
     * Constructs an AdmissionDTO with the specified name, age, and pet type.
     * 
     * @param name    the name of the pet
     * @param age     the age of the pet
     * @param petType the type of the pet (e.g., Dog, Cat, RoboDog, RoboCat)
     */
    public AdmissionDTO(String name, Integer age, PetType petType) {
        this.name = name;
        this.age = age;
        this.petType = petType;
    }

    /**
     * Default constructor for AdmissionDTO, calls the superclass constructor.
     * Useful for frameworks that require a no-argument constructor.
     */
    public AdmissionDTO() {
        super();
    }

    /**
     * Retrieves the name of the pet.
     * 
     * @return the pet's name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of the pet.
     * 
     * @param name the pet's name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Retrieves the age of the pet.
     * 
     * @return the pet's age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets the age of the pet.
     * 
     * @param age the pet's age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Retrieves the type of the pet.
     * 
     * @return the pet's type (e.g., Dog, Cat, RoboDog, RoboCat)
     */
    public PetType getPetType() {
        return petType;
    }

    /**
     * Sets the type of the pet.
     * 
     * @param petType the type of the pet (e.g., Dog, Cat, RoboDog, RoboCat)
     */
    public void setPetType(PetType petType) {
        this.petType = petType;
    }
}
