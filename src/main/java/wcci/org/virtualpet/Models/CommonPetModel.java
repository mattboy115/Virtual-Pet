package wcci.org.virtualpet.Models;

import jakarta.persistence.*;
import wcci.org.virtualpet.Enums.*;
import wcci.org.virtualpet.Exceptions.ValidateException;
import wcci.org.virtualpet.Interfaces.*;
import wcci.org.virtualpet.Matrix.MatrixValues;

/**
 * Common Pet Model Class
 */
@MappedSuperclass
public abstract class CommonPetModel implements PetInterface {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq")
    @SequenceGenerator(name = "my_seq", sequenceName = "MY_SEQ", allocationSize = 1)
    private long id;
    private PetType petType;
    private String name;
    private Integer age;
    private int health;
    private int happiness;
    private DeathBy deathBy;

    //===================================Constructors==================================

    /**
     * Common Pet Parameters and initial values
     * 
     * @param petType
     * @param name
     * @param age
     * @throws ValidateException 
     */
    public CommonPetModel(PetType petType, String name, Integer age) throws ValidateException {
        this.setPetType(petType);
        this.setName(name);
        this.setAge(age);
        this.setDeathBy(DeathBy.None);
        //Common Initial Matrix Values
        switch (petType) {
            case Dog: {
                this.happiness = MatrixValues.getMatrixValues()[PetActions.DogHappiness.ordinal()][Actions.Initialize.ordinal()];
                this.health = MatrixValues.getMatrixValues()[PetActions.DogHealth.ordinal()][Actions.Initialize.ordinal()];
                break;
            }
            case Cat: {
                this.happiness = MatrixValues.getMatrixValues()[PetActions.CatHappiness.ordinal()][Actions.Initialize.ordinal()];
                this.health = MatrixValues.getMatrixValues()[PetActions.CatHealth.ordinal()][Actions.Initialize.ordinal()];
                break;
            }
            case RoboDog: {
                this.happiness = MatrixValues.getMatrixValues()[PetActions.RoboDogHappiness.ordinal()][Actions.Initialize.ordinal()];
                this.health = MatrixValues.getMatrixValues()[PetActions.RoboDogHealth.ordinal()][Actions.Initialize.ordinal()];
                break;
            }
            case RoboCat: {
                this.happiness = MatrixValues.getMatrixValues()[PetActions.RoboCatHappiness.ordinal()][Actions.Initialize.ordinal()];
                this.health = MatrixValues.getMatrixValues()[PetActions.RoboCatHealth.ordinal()][Actions.Initialize.ordinal()];
                break;
            }
        }
    }

    //===================================Getters and Setters=======================================

    public CommonPetModel() {
    }

    public long getId() {
        return id;
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

    public void setName(String name) throws ValidateException {
        this.name = name;
        if (name == null) {
            throw new ValidateException("Cannot be null!");
        }
        if (name.length() == 0) {
            throw new ValidateException("This pet needs a name.");
        }
        if (name.length() > 50) {
            throw new ValidateException("You can't have a name longer than 50 characters.");
        }
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) throws ValidateException {
        this.age = age;
        if (age == null) {
            throw new ValidateException("You need to enter an age.");
        }
        if (age <= 0) {
            throw new ValidateException("Age cannot be 0.");
        }
        if (age > 20) {
            throw new ValidateException("Age cannot be higher than 20.");
        }
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        if (this.health <= 0) {
            this.health = 0;
            deathBy = DeathBy.Medical;
        }
        if (this.health > 100) {
            this.health = 100;
        }
        
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
        if (this.happiness < 0) {
            this.happiness = 0;
            deathBy = DeathBy.Boredom;
        }
        if (this.happiness > 100) {
            this.happiness = 100;
        }
        
    }

    public DeathBy getDeathBy() {
        return deathBy;
    }

    public void setDeathBy(DeathBy deathBy) {
        this.deathBy = deathBy;
    }

    public boolean isDead() {
        return (deathBy != DeathBy.None);
    }
//================================Methods=======================================
    /**
     * This method checks health of pet. Outputs message for different health ranges.
     */
    public String checkHealth() {
        String result = " ";
        // If not dead
        if (!this.isDead()) {
            result = this.name + "'s health is " + this.health + ".";
            if (this.health < 20) {
                result = "This pet is very unhealthy. You should heal them.";
            } else if (this.health > 70) {
                result = "This pet looks pretty healthy overall. Great job!";
            } else {
                result = "This pet is decently healthy overall.";
            }
            return result;

        }
        // If dead, cause of death is shown
        else {
            result = "This pet died from " + this.deathBy + ".";
        }
        return result;
    }

    /**
     * This method checks happiness of pet. Outputs message for different happiness ranges.
     */
    public String checkHappiness() {
        String result = " ";
        // If not dead
        if (!this.isDead()) {
            // Checks happiness level. Additional messages for extremes.
            if (this.happiness < 20) {
                result = "This pet is so sad. If you don't do something he may die from boredom.";
            } else if (this.happiness > 70) {
                result = "This pet is the happiest I've seen today. They must get lots of attention";
            } else {
                result = "This pet seems pretty happy.";
            }
            return result;
        }
        // If dead, cause of death is shown
        else {
            result = "This pet died from " + this.deathBy + ".";
        }
        return result;
    }

    //==============================Abstract Methods=====================================
    /**
     * Various abstract Method calls for speaking, feeding, giving water, playing,
     * healing and the passage of time.
     */
    public abstract String speak();

    public abstract void feed();

    public abstract void water();

    public abstract void play();

    public abstract void heal();

    public abstract void passageOfTime();

    public abstract String getStatus();
}