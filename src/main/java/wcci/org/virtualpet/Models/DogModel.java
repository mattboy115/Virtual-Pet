package wcci.org.virtualpet.Models;

import jakarta.persistence.Entity;
import wcci.org.virtualpet.Enums.PetType;
import wcci.org.virtualpet.Exceptions.ValidateException;
@Entity
public class DogModel extends PetModel {
    public DogModel() {
        super();
    }
        public DogModel(String name, Integer age) throws ValidateException {
            super(PetType.Dog,name,age); //PetModel = super()
        }
    
        @Override
        public String speak() {
            if (isDead()) {
                return "The dog is dead. Nothing happens.";
            }
            else if (getHappiness() < 20) {
                return "Grrrrr";
            }
            else if (getHappiness() >= 50) {
                return "Bark";
            }
            else {
                return "Panting";
            }
        }

        @Override
        public String getStatus() {
            String results = "Hunger: " + getHunger() + "% || ";
            results += "Thirst: " + getThirst() + "% || ";
            results += "Happiness: " + getHappiness() + "% || ";
            results += "Health: " + getHealth() + "%.";
            return results;
        }
    
}
