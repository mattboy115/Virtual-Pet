package wcci.org.virtualpet.Models;

import jakarta.persistence.MappedSuperclass;
import wcci.org.virtualpet.Enums.*;
import wcci.org.virtualpet.Exceptions.ValidateException;
import wcci.org.virtualpet.Matrix.*;

/**
 * Pet model class.
 */
@MappedSuperclass
public abstract class PetModel extends CommonPetModel {
        private int hunger;
        private int thirst;

        // ============================Constructor=====================================
        public PetModel() {

        }

        /**
         * Pet Model Parameters
         * 
         * @param petType
         * @param name
         * @param age
         * @throws ValidateException 
         */
        public PetModel(PetType petType, String name, int age) throws ValidateException {
                super(petType, name, age);
                // If Dog
                if (petType == PetType.Dog) {
                        this.hunger = MatrixValues.getMatrixValues()[PetActions.DogHunger.ordinal()][Actions.Initialize
                                        .ordinal()];
                        this.thirst = MatrixValues.getMatrixValues()[PetActions.DogThirst.ordinal()][Actions.Initialize
                                        .ordinal()];
                }
                // If Cat
                else {
                        this.hunger = MatrixValues.getMatrixValues()[PetActions.CatHunger.ordinal()][Actions.Initialize
                                        .ordinal()];
                        this.thirst = MatrixValues.getMatrixValues()[PetActions.CatThirst.ordinal()][Actions.Initialize
                                        .ordinal()];
                }

        }

        // ============================Getters and Setters==============================
        /**
         * Getters and setters for the Pet Model class.
         */
        public int getThirst() {
                return thirst;
        }

        public void setThirst(int thirst) {
                this.thirst = thirst;
                if (this.thirst >= 100) {
                        this.thirst = 100;
                        this.setDeathBy(DeathBy.Thirst);
                } else if (thirst <= 0) {
                        this.thirst = 0;
                }
        }

        public int getHunger() {
                return hunger;
        }

        public void setHunger(int hunger) {
                this.hunger = hunger;
                if (this.hunger <= 0) {
                        this.hunger = 0;
                }
                if (this.hunger >= 100) {
                        this.hunger = 100;
                        setDeathBy(DeathBy.Hunger);
                }
        }

        // ==============================Methods=========================================

        /**
         * Feed method. Lowers hunger and increases everything else.
         */
        @Override
        public void feed() {
                if (!this.isDead()) {
                        // If Dog
                        if (getPetType() == PetType.Dog) {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.DogHealth
                                                                .ordinal()][Actions.Feed.ordinal()]);
                                // Happiness
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.DogHappiness
                                                                .ordinal()][Actions.Feed.ordinal()]);
                                // Hunger
                                setHunger(getHunger()
                                                + MatrixValues.getMatrixValues()[PetActions.DogHunger
                                                                .ordinal()][Actions.Feed.ordinal()]);
                                // Thirst
                                setThirst(getThirst()
                                                + MatrixValues.getMatrixValues()[PetActions.DogThirst
                                                                .ordinal()][Actions.Feed.ordinal()]);
                        }
                        // If Cat
                        else {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.CatHealth
                                                                .ordinal()][Actions.Feed.ordinal()]);
                                // Happiness
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.CatHappiness
                                                                .ordinal()][Actions.Feed.ordinal()]);
                                // Hunger
                                setHunger(getHunger()
                                                + MatrixValues.getMatrixValues()[PetActions.CatHunger
                                                                .ordinal()][Actions.Feed.ordinal()]);
                                // Thirst
                                setThirst(getThirst()
                                                + MatrixValues.getMatrixValues()[PetActions.CatThirst
                                                                .ordinal()][Actions.Feed.ordinal()]);
                        }
                }
        }

        /**
         * Play method. Raise happiness and health and also thirst and hunger.
         */
        @Override
        public void play() {
                if (!this.isDead()) {
                        // If Dog
                        if (getPetType() == PetType.Dog) {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.DogHealth
                                                                .ordinal()][Actions.Play.ordinal()]);
                                // Happiness
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.DogHappiness
                                                                .ordinal()][Actions.Play.ordinal()]);
                                // Hunger
                                setHunger(getHunger()
                                                + MatrixValues.getMatrixValues()[PetActions.DogHunger
                                                                .ordinal()][Actions.Play.ordinal()]);
                                // Thirst
                                setThirst(getThirst()
                                                + MatrixValues.getMatrixValues()[PetActions.DogThirst
                                                                .ordinal()][Actions.Play.ordinal()]);
                        }
                        // If Cat
                        else {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.CatHealth
                                                                .ordinal()][Actions.Play.ordinal()]);
                                // Happiness
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.CatHappiness
                                                                .ordinal()][Actions.Play.ordinal()]);

                                // Hunger
                                setHunger(getHunger()
                                                + MatrixValues.getMatrixValues()[PetActions.CatHunger
                                                                .ordinal()][Actions.Play.ordinal()]);
                                // Thirst
                                setThirst(getThirst()
                                                + MatrixValues.getMatrixValues()[PetActions.CatThirst
                                                                .ordinal()][Actions.Play.ordinal()]);
                        }
                }
        }

        /**
         * Raise health and happiness but also increase hunger.
         */
        @Override
        public void heal() {
                if (!this.isDead()) {
                        // If Dog
                        if (getPetType() == PetType.Dog) {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.DogHealth
                                                                .ordinal()][Actions.Heal.ordinal()]);
                                // Happiness
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.DogHappiness
                                                                .ordinal()][Actions.Heal.ordinal()]);

                                // Hunger
                                setHunger(getHunger()
                                                + MatrixValues.getMatrixValues()[PetActions.DogHunger
                                                                .ordinal()][Actions.Heal.ordinal()]);
                                // Thirst
                                setThirst(getThirst()
                                                + MatrixValues.getMatrixValues()[PetActions.DogThirst
                                                                .ordinal()][Actions.Heal.ordinal()]);
                        }
                        // If Cat
                        else {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.CatHealth
                                                                .ordinal()][Actions.Heal.ordinal()]);
                                // Happiness
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.CatHappiness
                                                                .ordinal()][Actions.Heal.ordinal()]);
                                // Hunger
                                setHunger(getHunger()
                                                + MatrixValues.getMatrixValues()[PetActions.CatHunger
                                                                .ordinal()][Actions.Heal.ordinal()]);
                                // Thirst
                                setThirst(getThirst()
                                                + MatrixValues.getMatrixValues()[PetActions.CatThirst
                                                                .ordinal()][Actions.Heal.ordinal()]);
                        }
                }
        }

        /**
         * Raise health and happiness but decrease thirst.
         */
        @Override
        public void water() {
                if (!this.isDead()) {
                        // If Dog
                        if (getPetType() == PetType.Dog) {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.DogHealth
                                                                .ordinal()][Actions.Water.ordinal()]);
                                // Happiness
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.DogHappiness
                                                                .ordinal()][Actions.Water.ordinal()]);
                                // Hunger
                                setHunger(getHunger()
                                                + MatrixValues.getMatrixValues()[PetActions.DogHunger
                                                                .ordinal()][Actions.Water.ordinal()]);
                                // Thirst
                                setThirst(getThirst()
                                                + MatrixValues.getMatrixValues()[PetActions.DogThirst
                                                                .ordinal()][Actions.Water.ordinal()]);
                        }
                        // If Cat
                        else {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.CatHealth
                                                                .ordinal()][Actions.Water.ordinal()]);
                                // Happiness
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.CatHappiness
                                                                .ordinal()][Actions.Water.ordinal()]);
                                // Hunger
                                setHunger(getHunger()
                                                + MatrixValues.getMatrixValues()[PetActions.CatHunger
                                                                .ordinal()][Actions.Water.ordinal()]);
                                // Thirst
                                setThirst(getThirst()
                                                + MatrixValues.getMatrixValues()[PetActions.CatThirst
                                                                .ordinal()][Actions.Water.ordinal()]);
                        }
                }
        }

        /**
         * Method for the passage of time.
         */
        @Override
        public void passageOfTime() {
                if (!this.isDead()) {
                        // If Dog
                        if (getPetType() == PetType.Dog) {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.DogHealth
                                                                .ordinal()][Actions.PassageOfTime.ordinal()]);
                                // Happiness
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.DogHappiness
                                                                .ordinal()][Actions.PassageOfTime.ordinal()]);
                                // Hunger
                                setHunger(getHunger()
                                                + MatrixValues.getMatrixValues()[PetActions.DogHunger
                                                                .ordinal()][Actions.PassageOfTime.ordinal()]);
                                // Thirst
                                setThirst(getThirst()
                                                + MatrixValues.getMatrixValues()[PetActions.DogThirst
                                                                .ordinal()][Actions.PassageOfTime.ordinal()]);
                        }
                        // If Dog
                        else {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.CatHealth
                                                                .ordinal()][Actions.PassageOfTime.ordinal()]);
                                // Happiness
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.CatHappiness
                                                                .ordinal()][Actions.PassageOfTime.ordinal()]);
                                // Hunger
                                setHunger(getHunger()
                                                + MatrixValues.getMatrixValues()[PetActions.CatHunger
                                                                .ordinal()][Actions.PassageOfTime.ordinal()]);
                                // Thirst
                                setThirst(getThirst()
                                                + MatrixValues.getMatrixValues()[PetActions.CatThirst
                                                                .ordinal()][Actions.PassageOfTime.ordinal()]);
                        }
                }
                System.out.println(getDeathBy() + toString());
        }

        // ============================Abstract-Methods==================================
        /**
         * This method makes the pet speak. This result will be different depending on
         * the type of pet.
         */
        public abstract String speak();

        // ==============================ToString============================================
        /**
         * toString Method for the petModel.
         */
        @Override
        public String toString() {
                return "PetModel [name=" + getName() + ", hunger=" + hunger + ", thirst=" + thirst + ", happiness ="
                                + getHappiness() + ", health =" + getHealth() + "]";
        }

}
