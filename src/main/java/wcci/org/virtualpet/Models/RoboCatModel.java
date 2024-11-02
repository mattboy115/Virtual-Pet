package wcci.org.virtualpet.Models;
import jakarta.persistence.Entity;
import wcci.org.virtualpet.Enums.PetType;
import wcci.org.virtualpet.Exceptions.ValidateException;
@Entity
public class RoboCatModel extends RoboPetModel {
    public RoboCatModel() {
        super();
    }
    public RoboCatModel(String name, int age) throws ValidateException {
        super(PetType.RoboCat,name,age); //PetModel = super()
    }

    @Override
    public String speak() {
        if (isDead()) {
            return "The Robocat is dead. Nothing happens.";
        }
        else if (getHappiness() < 20) {
            return "~Grrrrr~";
        }
        else if (getHappiness() >= 50) {
            return "~Pur~";
        }
        else {
            return "~Meow~";
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
