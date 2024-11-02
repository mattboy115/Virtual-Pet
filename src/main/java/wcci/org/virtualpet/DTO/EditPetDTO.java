package wcci.org.virtualpet.DTO;

/**
 * Data Transfer Object (DTO) for editing an existing pet in the system.
 * This class contains information such as the pet's ID, name, and age.
 * It extends the {@link ErrorDataDTO} to handle any potential error data.
 */
public class EditPetDTO extends ErrorDataDTO {
    private long id;
    private String name;
    private int age;

    /**
     * Constructs an EditPetDTO with the specified id, name, and age.
     * 
     * @param id   the unique identifier of the pet
     * @param name the name of the pet
     * @param age  the age of the pet
     */
    public EditPetDTO(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    /**
     * Default constructor for EditPetDTO, calls the superclass constructor.
     * Useful for frameworks that require a no-argument constructor.
     */
    public EditPetDTO() {
        super();
    }

    /**
     * Retrieves the unique identifier of the pet.
     * 
     * @return the pet's ID
     */
    public long getId() {
        return id;
    }

    /**
     * Sets the unique identifier of the pet.
     * 
     * @param id the pet's ID
     */
    public void setId(long id) {
        this.id = id;
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
    public int getAge() {
        return age;
    }

    /**
     * Sets the age of the pet.
     * 
     * @param age the pet's age
     */
    public void setAge(int age) {
        this.age = age;
    }
}
