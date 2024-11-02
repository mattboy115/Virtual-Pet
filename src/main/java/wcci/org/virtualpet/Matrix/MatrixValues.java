package wcci.org.virtualpet.Matrix;

import wcci.org.virtualpet.Enums.*;

public class MatrixValues {
    static int[][] values = new int[16][6];

    public static int[][] getMatrixValues() {
        if (values[0][0] == 0) {
            // ===========================Passage-of-Time==============================
            values[PetActions.DogHealth.ordinal()][Actions.PassageOfTime.ordinal()] = -3;
            values[PetActions.DogHappiness.ordinal()][Actions.PassageOfTime.ordinal()] = -5;
            values[PetActions.DogThirst.ordinal()][Actions.PassageOfTime.ordinal()] = 6;
            values[PetActions.DogHunger.ordinal()][Actions.PassageOfTime.ordinal()] = 7;

            values[PetActions.CatHealth.ordinal()][Actions.PassageOfTime.ordinal()] = -2;
            values[PetActions.CatHappiness.ordinal()][Actions.PassageOfTime.ordinal()] = -4;
            values[PetActions.CatThirst.ordinal()][Actions.PassageOfTime.ordinal()] = 9;
            values[PetActions.CatHunger.ordinal()][Actions.PassageOfTime.ordinal()] = 6;

            values[PetActions.RoboDogHealth.ordinal()][Actions.PassageOfTime.ordinal()] = -4;
            values[PetActions.RoboDogHappiness.ordinal()][Actions.PassageOfTime.ordinal()] = -5;
            values[PetActions.RoboDogOil.ordinal()][Actions.PassageOfTime.ordinal()] = -8;
            values[PetActions.RoboDogBattery.ordinal()][Actions.PassageOfTime.ordinal()] = -9;

            values[PetActions.RoboCatHealth.ordinal()][Actions.PassageOfTime.ordinal()] = -4;
            values[PetActions.RoboCatHappiness.ordinal()][Actions.PassageOfTime.ordinal()] = -4;
            values[PetActions.RoboCatOil.ordinal()][Actions.PassageOfTime.ordinal()] = -7;
            values[PetActions.RoboCatBattery.ordinal()][Actions.PassageOfTime.ordinal()] = -8;

            // ==============================Initialize===================================
            values[PetActions.DogHealth.ordinal()][Actions.Initialize.ordinal()] = 63;
            values[PetActions.DogHappiness.ordinal()][Actions.Initialize.ordinal()] = 54;
            values[PetActions.DogThirst.ordinal()][Actions.Initialize.ordinal()] = 37;
            values[PetActions.DogHunger.ordinal()][Actions.Initialize.ordinal()] = 65;

            values[PetActions.CatHealth.ordinal()][Actions.Initialize.ordinal()] = 70;
            values[PetActions.CatHappiness.ordinal()][Actions.Initialize.ordinal()] = 80;
            values[PetActions.CatThirst.ordinal()][Actions.Initialize.ordinal()] = 55;
            values[PetActions.CatHunger.ordinal()][Actions.Initialize.ordinal()] = 42;

            values[PetActions.RoboDogHealth.ordinal()][Actions.Initialize.ordinal()] = 80;
            values[PetActions.RoboDogHappiness.ordinal()][Actions.Initialize.ordinal()] = 60;
            values[PetActions.RoboDogOil.ordinal()][Actions.Initialize.ordinal()] = 20;
            values[PetActions.RoboDogBattery.ordinal()][Actions.Initialize.ordinal()] = 60;

            values[PetActions.RoboCatHealth.ordinal()][Actions.Initialize.ordinal()] = 62;
            values[PetActions.RoboCatHappiness.ordinal()][Actions.Initialize.ordinal()] = 75;
            values[PetActions.RoboCatOil.ordinal()][Actions.Initialize.ordinal()] = 30;
            values[PetActions.RoboCatBattery.ordinal()][Actions.Initialize.ordinal()] = 56;

            // ==============================Play===================================
            values[PetActions.DogHealth.ordinal()][Actions.Play.ordinal()] = 5;
            values[PetActions.DogHappiness.ordinal()][Actions.Play.ordinal()] = 15;
            values[PetActions.DogThirst.ordinal()][Actions.Play.ordinal()] = 12;
            values[PetActions.DogHunger.ordinal()][Actions.Play.ordinal()] = 11;

            values[PetActions.CatHealth.ordinal()][Actions.Play.ordinal()] = 9;
            values[PetActions.CatHappiness.ordinal()][Actions.Play.ordinal()] = 22;
            values[PetActions.CatThirst.ordinal()][Actions.Play.ordinal()] = 14;
            values[PetActions.CatHunger.ordinal()][Actions.Play.ordinal()] = 10;

            values[PetActions.RoboDogHealth.ordinal()][Actions.Play.ordinal()] = 7;
            values[PetActions.RoboDogHappiness.ordinal()][Actions.Play.ordinal()] = 23;
            values[PetActions.RoboDogOil.ordinal()][Actions.Play.ordinal()] = -2;
            values[PetActions.RoboDogBattery.ordinal()][Actions.Play.ordinal()] = -16;

            values[PetActions.RoboCatHealth.ordinal()][Actions.Play.ordinal()] = 8;
            values[PetActions.RoboCatHappiness.ordinal()][Actions.Play.ordinal()] = 22;
            values[PetActions.RoboCatOil.ordinal()][Actions.Play.ordinal()] = -3;
            values[PetActions.RoboCatBattery.ordinal()][Actions.Play.ordinal()] = -14;

            // ==============================Heal===================================
            values[PetActions.DogHealth.ordinal()][Actions.Heal.ordinal()] = 15;
            values[PetActions.DogHappiness.ordinal()][Actions.Heal.ordinal()] = 5;
            values[PetActions.DogThirst.ordinal()][Actions.Heal.ordinal()] = 9;
            values[PetActions.DogHunger.ordinal()][Actions.Heal.ordinal()] = 9;

            values[PetActions.CatHealth.ordinal()][Actions.Heal.ordinal()] = 20;
            values[PetActions.CatHappiness.ordinal()][Actions.Heal.ordinal()] = 8;
            values[PetActions.CatThirst.ordinal()][Actions.Heal.ordinal()] = 8;
            values[PetActions.CatHunger.ordinal()][Actions.Heal.ordinal()] = 8;

            values[PetActions.RoboDogHealth.ordinal()][Actions.Heal.ordinal()] = 17;
            values[PetActions.RoboDogHappiness.ordinal()][Actions.Heal.ordinal()] = 9;
            values[PetActions.RoboDogOil.ordinal()][Actions.Heal.ordinal()] = 0;
            values[PetActions.RoboDogBattery.ordinal()][Actions.Heal.ordinal()] = -5;

            values[PetActions.RoboCatHealth.ordinal()][Actions.Heal.ordinal()] = 15;
            values[PetActions.RoboCatHappiness.ordinal()][Actions.Heal.ordinal()] = 10;
            values[PetActions.RoboCatOil.ordinal()][Actions.Heal.ordinal()] = 0;
            values[PetActions.RoboCatBattery.ordinal()][Actions.Heal.ordinal()] = -7;

            // ==============================Feed===================================
            values[PetActions.DogHealth.ordinal()][Actions.Feed.ordinal()] = 5;
            values[PetActions.DogHappiness.ordinal()][Actions.Feed.ordinal()] = 15;
            values[PetActions.DogThirst.ordinal()][Actions.Feed.ordinal()] = 4;
            values[PetActions.DogHunger.ordinal()][Actions.Feed.ordinal()] = -25;

            values[PetActions.CatHealth.ordinal()][Actions.Feed.ordinal()] = 5;
            values[PetActions.CatHappiness.ordinal()][Actions.Feed.ordinal()] = 20;
            values[PetActions.CatThirst.ordinal()][Actions.Feed.ordinal()] = 8;
            values[PetActions.CatHunger.ordinal()][Actions.Feed.ordinal()] = -20;

            values[PetActions.RoboDogHealth.ordinal()][Actions.Feed.ordinal()] = 6;
            values[PetActions.RoboDogHappiness.ordinal()][Actions.Feed.ordinal()] = 12;
            values[PetActions.RoboDogOil.ordinal()][Actions.Feed.ordinal()] = 0;
            values[PetActions.RoboDogBattery.ordinal()][Actions.Feed.ordinal()] = 40;

            values[PetActions.RoboCatHealth.ordinal()][Actions.Feed.ordinal()] = 5;
            values[PetActions.RoboCatHappiness.ordinal()][Actions.Feed.ordinal()] = 14;
            values[PetActions.RoboCatOil.ordinal()][Actions.Feed.ordinal()] = 0;
            values[PetActions.RoboCatBattery.ordinal()][Actions.Feed.ordinal()] = 40;

            // ==============================Water===================================
            values[PetActions.DogHealth.ordinal()][Actions.Water.ordinal()] = 5;
            values[PetActions.DogHappiness.ordinal()][Actions.Water.ordinal()] = 12;
            values[PetActions.DogThirst.ordinal()][Actions.Water.ordinal()] = -24;
            values[PetActions.DogHunger.ordinal()][Actions.Water.ordinal()] = 0;

            values[PetActions.CatHealth.ordinal()][Actions.Water.ordinal()] = 5;
            values[PetActions.CatHappiness.ordinal()][Actions.Water.ordinal()] = 17;
            values[PetActions.CatThirst.ordinal()][Actions.Water.ordinal()] = -26;
            values[PetActions.CatHunger.ordinal()][Actions.Water.ordinal()] = 0;

            values[PetActions.RoboDogHealth.ordinal()][Actions.Water.ordinal()] = 6;
            values[PetActions.RoboDogHappiness.ordinal()][Actions.Water.ordinal()] = 12;
            values[PetActions.RoboDogOil.ordinal()][Actions.Water.ordinal()] = 30;
            values[PetActions.RoboDogBattery.ordinal()][Actions.Water.ordinal()] = 0;

            values[PetActions.RoboCatHealth.ordinal()][Actions.Water.ordinal()] = 6;
            values[PetActions.RoboCatHappiness.ordinal()][Actions.Water.ordinal()] = 12;
            values[PetActions.RoboCatOil.ordinal()][Actions.Water.ordinal()] = 30;
            values[PetActions.RoboCatBattery.ordinal()][Actions.Water.ordinal()] = 0;
        }
        return values;
    }
}
