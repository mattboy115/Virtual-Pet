package wcci.org.virtualpet.DTO;

import wcci.org.virtualpet.Enums.PetType;

public class HappinessDTO extends ErrorDataDTO {
    private PetType petType;
    private String name;
    private String health;

    public HappinessDTO(PetType petType, String name, String happiness) {
        this.petType = petType;
        this.name = name;
        this.health = happiness;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }
}