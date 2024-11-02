package wcci.org.virtualpet.Models;

import jakarta.persistence.MappedSuperclass;
import wcci.org.virtualpet.Enums.*;
import wcci.org.virtualpet.Exceptions.ValidateException;
import wcci.org.virtualpet.Matrix.MatrixValues;

/**
 * Pet model class.
 */
@MappedSuperclass
public abstract class RoboPetModel extends CommonPetModel {

        private int oil;
        private int battery;

        // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Constructors $$$$$$$$$$$$$$$$$$$$$$$$$$$$$
        public RoboPetModel() {

        }

        // Pet Model constructor
        public RoboPetModel(PetType petType, String name, int age) throws ValidateException {
                super(petType, name, age);
                // If RoboDog
                if (petType == PetType.RoboDog) {
                        this.battery = MatrixValues.getMatrixValues()[PetActions.RoboDogBattery
                                        .ordinal()][Actions.Initialize.ordinal()];
                        this.oil = MatrixValues.getMatrixValues()[PetActions.RoboDogOil.ordinal()][Actions.Initialize
                                        .ordinal()];
                }
                // If RoboCat
                else {
                        this.battery = MatrixValues.getMatrixValues()[PetActions.RoboCatBattery
                                        .ordinal()][Actions.Initialize.ordinal()];
                        this.oil = MatrixValues.getMatrixValues()[PetActions.RoboCatOil.ordinal()][Actions.Initialize
                                        .ordinal()];
                }
                setDeathBy(DeathBy.None);
        }

        // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ Getters/Setters $$$$$$$$$$$$$$$$$$$$$$$$
        /**
         * Getters and setters for the Pet Model class.
         */
        private int getDefaultOil(PetType petType) {
                if (petType == PetType.RoboCat) {
                        return MatrixValues.getMatrixValues()[PetActions.RoboCatOil.ordinal()][Actions.Initialize
                                        .ordinal()];
                } else {
                        return MatrixValues.getMatrixValues()[PetActions.RoboDogOil.ordinal()][Actions.Initialize
                                        .ordinal()];
                }
        }

        private int getDefaultBattery(PetType petType) {
                if (petType == PetType.RoboCat) {
                        return MatrixValues.getMatrixValues()[PetActions.RoboCatBattery.ordinal()][Actions.Initialize
                                        .ordinal()];
                } else {
                        return MatrixValues.getMatrixValues()[PetActions.RoboDogBattery.ordinal()][Actions.Initialize
                                        .ordinal()];
                }
        }

        public int getBattery() {
                return battery;
        }

        public void setBattery(int battery) {
                this.battery = battery;
                if (this.battery >= 100) {
                        this.battery = 100;
                } else if (battery <= 0) {
                        this.battery = getDefaultBattery(getPetType());
                }
        }

        public int getOil() {
                return oil;
        }

        public void setOil(int oil) {
                this.oil = oil;
                if (this.oil < 0) {
                        this.oil = getDefaultOil(getPetType());
                } else if (oil > 100) {
                        this.oil = 100;
                }

        }

        // $$$$$$$$$$$$$$$$$$$$$$$$$$$ Methods $$$$$$$$$$$$$$$$$$$$$$$$$
        /**
         * This method shows a pet as dead by returning deathBy with a value of not
         * none.
         */

        /**
         * Lowers hunger but increases happiness and health.
         */
        @Override
        public void feed() {
                if (!this.isDead()) {
                        // If RoboDog
                        if (getPetType() == PetType.RoboDog) {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogHealth
                                                                .ordinal()][Actions.Feed.ordinal()]);
                                // Happiness
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogHappiness
                                                                .ordinal()][Actions.Feed
                                                                                .ordinal()]);

                                // Health should increase
                                setBattery(getBattery()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogBattery
                                                                .ordinal()][Actions.Feed.ordinal()]);
                                // Happiness should increase
                                setOil(getOil()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogOil
                                                                .ordinal()][Actions.Feed.ordinal()]);
                        }
                        // If RoboCat
                        else {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatHealth
                                                                .ordinal()][Actions.Feed.ordinal()]);
                                // Happiness should increase
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatHappiness
                                                                .ordinal()][Actions.Feed
                                                                                .ordinal()]);

                                // Health should increase
                                setBattery(getBattery()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatBattery
                                                                .ordinal()][Actions.Feed.ordinal()]);
                                // Happiness should increase
                                setOil(getOil()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatOil
                                                                .ordinal()][Actions.Feed.ordinal()]);
                        }
                }
        }

        /**
         * Raise health and happiness but also increase hunger.
         */
        @Override
        public void play() {
                if (!this.isDead()) {
                        // If RoboDog
                        if (getPetType() == PetType.RoboDog) {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogHealth
                                                                .ordinal()][Actions.Play.ordinal()]);
                                // Happiness should increase
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogHappiness
                                                                .ordinal()][Actions.Play
                                                                                .ordinal()]);

                                // Health should increase
                                setBattery(getBattery()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogBattery
                                                                .ordinal()][Actions.Play.ordinal()]);
                                // Happiness should increase
                                setOil(getOil()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogOil
                                                                .ordinal()][Actions.Play.ordinal()]);
                        }
                        // If RoboCat
                        else {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatHealth
                                                                .ordinal()][Actions.Play.ordinal()]);
                                // Happiness should increase
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatHappiness
                                                                .ordinal()][Actions.Play
                                                                                .ordinal()]);

                                // Health should increase
                                setBattery(getBattery()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatBattery
                                                                .ordinal()][Actions.Play.ordinal()]);
                                // Happiness should increase
                                setOil(getOil()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatOil
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
                        // If RoboDog
                        if (getPetType() == PetType.RoboDog) {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogHealth
                                                                .ordinal()][Actions.Heal.ordinal()]);
                                // Happiness should increase
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogHappiness
                                                                .ordinal()][Actions.Heal
                                                                                .ordinal()]);

                                // Health should increase
                                setBattery(getBattery()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogBattery
                                                                .ordinal()][Actions.Heal.ordinal()]);
                                // Happiness should increase
                                setOil(getOil()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogOil
                                                                .ordinal()][Actions.Heal.ordinal()]);
                        }
                        // If RoboCat
                        else {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatHealth
                                                                .ordinal()][Actions.Heal.ordinal()]);
                                // Happiness should increase
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatHappiness
                                                                .ordinal()][Actions.Heal
                                                                                .ordinal()]);

                                // Health should increase
                                setBattery(getBattery()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatBattery
                                                                .ordinal()][Actions.Heal.ordinal()]);
                                // Happiness should increase
                                setOil(getOil()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatOil
                                                                .ordinal()][Actions.Heal.ordinal()]);
                        }
                }
        }

        /**
         * Raise health and happiness but also increase battery.
         */
        @Override
        public void water() {
                if (!this.isDead()) {
                        // If RoboDog
                        if (getPetType() == PetType.RoboDog) {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogHealth
                                                                .ordinal()][Actions.Water.ordinal()]);
                                // Happiness should increase
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogHappiness
                                                                .ordinal()][Actions.Water
                                                                                .ordinal()]);

                                // Health should increase
                                setBattery(getBattery()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogBattery
                                                                .ordinal()][Actions.Water.ordinal()]);
                                // Happiness should increase
                                setOil(getOil()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogOil
                                                                .ordinal()][Actions.Water.ordinal()]);
                        }
                        // If RoboCat
                        else {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatHealth
                                                                .ordinal()][Actions.Water.ordinal()]);
                                // Happiness should increase
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatHappiness
                                                                .ordinal()][Actions.Water
                                                                                .ordinal()]);

                                // Health should increase
                                setBattery(getBattery()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatBattery
                                                                .ordinal()][Actions.Water.ordinal()]);
                                // Happiness should increase
                                setOil(getOil()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatOil
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
                        // If RoboDog
                        if (getPetType() == PetType.RoboDog) {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogHealth
                                                                .ordinal()][Actions.PassageOfTime
                                                                                .ordinal()]);
                                // Happiness should increase
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogHappiness
                                                                .ordinal()][Actions.PassageOfTime
                                                                                .ordinal()]);

                                // Health should increase
                                setBattery(getBattery()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogBattery
                                                                .ordinal()][Actions.PassageOfTime
                                                                                .ordinal()]);
                                // Happiness should increase
                                setOil(getOil()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboDogOil
                                                                .ordinal()][Actions.PassageOfTime
                                                                                .ordinal()]);
                        }
                        // If RoboCat
                        else {
                                // Health
                                setHealth(getHealth()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatHealth
                                                                .ordinal()][Actions.PassageOfTime
                                                                                .ordinal()]);
                                // Happiness should increase
                                setHappiness(getHappiness()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatHappiness
                                                                .ordinal()][Actions.PassageOfTime
                                                                                .ordinal()]);

                                // Health should increase
                                setBattery(getBattery()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatBattery
                                                                .ordinal()][Actions.PassageOfTime
                                                                                .ordinal()]);
                                // Happiness should increase
                                setOil(getOil()
                                                + MatrixValues.getMatrixValues()[PetActions.RoboCatOil
                                                                .ordinal()][Actions.PassageOfTime
                                                                                .ordinal()]);
                        }
                }
        }

        // $$$$$$$$$$$$$$$$$$$$$$ Abstract Methods $$$$$$$$$$$$$$$$$$$$$$$$$
        /**
         * This method makes the pet speak. This result will be different depending on
         * the type of pet.
         */
        public abstract String speak();

        /**
         * toString Method for the petModel.
         */
        @Override
        public String toString() {
                return "RoboPetModel [name=" + getName() + ", oil=" + oil + ", battery=" + battery + ", happiness ="
                                + getHappiness() + ", health =" + getHealth() + "]";
        }
}
