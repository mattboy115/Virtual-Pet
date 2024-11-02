package wcci.org.virtualpet.BOService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import wcci.org.virtualpet.Models.*;
import wcci.org.virtualpet.Repositories.*;

import java.util.Random;

/**
 * This class populates the pet repositories with default data when the application starts.
 * It implements CommandLineRunner to run after the application context is loaded.
 */
@Component
public class Populator implements CommandLineRunner {

    private final Random random = new Random();
    private final int min = 2; // Minimum age for pets
    private final int max = 15; // Maximum age for pets

    @Resource
    private final CatRepository cats;

    @Resource
    private final DogRepository dogs;

    @Resource
    private final RoboCatRepository roboCats;

    @Resource
    private final RoboDogRepository roboDogs;

    /**
     * Constructor to initialize the repositories for the different pet types.
     * 
     * @param cats the repository for CatModel objects
     * @param dogs the repository for DogModel objects
     * @param roboCats the repository for RoboCatModel objects
     * @param roboDogs the repository for RoboDogModel objects
     */
    public Populator(CatRepository cats, DogRepository dogs, RoboCatRepository roboCats, RoboDogRepository roboDogs) {
        this.cats = cats;
        this.dogs = dogs;
        this.roboCats = roboCats;
        this.roboDogs = roboDogs;
    }

    /**
     * Populates the repositories with default pets when the application starts.
     * This method is called automatically after the application context is loaded.
     * 
     * @param args command-line arguments passed to the application (not used here)
     * @throws Exception if any errors occur during execution
     */
    @Override
    public void run(String... args) throws Exception {
        // Populate Cat repository with default data
        CatModel cat = new CatModel("Goku", getRandomAge());
        cats.save(cat);

        cat = new CatModel("Kirby", getRandomAge());
        cats.save(cat);

        // Populate RoboCat repository with default data
        RoboCatModel roboCat = new RoboCatModel("Meowz", getRandomAge());
        roboCats.save(roboCat);

        roboCat = new RoboCatModel("Brasso", getRandomAge());
        roboCats.save(roboCat);

        // Populate Dog repository with default data
        DogModel dog = new DogModel("Bruno", getRandomAge());
        dogs.save(dog);

        dog = new DogModel("Jotaro", getRandomAge());
        dogs.save(dog);

        // Populate RoboDog repository with default data
        RoboDogModel roboDog = new RoboDogModel("Poochi", getRandomAge());
        roboDogs.save(roboDog);

        roboDog = new RoboDogModel("Techno", getRandomAge());
        roboDogs.save(roboDog);
    }

    /**
     * Generates a random age between the defined minimum and maximum values.
     * 
     * @return a randomly generated age for a pet
     */
    private int getRandomAge() {
        return random.nextInt(max - min) + min;
    }
}
