package wcci.org.virtualpet.DTO;

import wcci.org.virtualpet.Enums.PetType;

public class SpeakDTO extends ErrorDataDTO {
    private PetType petType;
    private String name;
    private String speak;

    public SpeakDTO(PetType petType, String name, String speak) {
        this.petType = petType;
        this.name = name;
        this.speak = speak;
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
public String getSpeak() {
    return speak;
}
public void setSpeak(String speak) {
    this.speak = speak;
}


}
