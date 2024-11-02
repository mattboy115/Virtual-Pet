package wcci.org.virtualpet.Models;

import jakarta.persistence.Entity;
import wcci.org.virtualpet.Enums.PetType;
import wcci.org.virtualpet.Exceptions.ValidateException;

@Entity
public class RoboDogModel extends RoboPetModel {
    public RoboDogModel() {
        super();
    }

    public RoboDogModel(String name, int age) throws ValidateException {
        super(PetType.RoboDog, name, age); // PetModel = super()
    }

    @Override
    public String speak() {
        if (isDead()) {
            return "The dog is dead. Nothing happens.";
        } else if (getHappiness() < 20) {
            return "~Grrrrr~";
        } else if (getHappiness() >= 50) {
            return "~Bark~";
        } else {
            return "~Panting~";
        }
    }

    @Override
    public String getStatus() {
        String results = "Battery: " + getBattery() + "% || ";
        results += "Oil: " + getHappiness() + "% || ";
        results += "Happiness: " + getHealth() + "% || ";
        results += "Health: " + getOil() + "%.";
        return results;
    }
}
