package wcci.org.virtualpet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import wcci.org.virtualpet.Enums.*;
import wcci.org.virtualpet.Exceptions.ValidateException;
import wcci.org.virtualpet.Models.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the DogModel class.
 * This class tests various scenarios for the DogModel class to ensure its methods
 * behave as expected.
 */
public class DogModelTest {

private DogModel dog;

    /**
     * Set up a new DogModel instance before each test.
     * This method initializes the DogModel instance with a default name and age.
     * @throws ValidateException 
     */
    @BeforeEach
    public void setUp() throws ValidateException {
       dog = new DogModel("Buddy", 3); // Initialize DogModel with name "Buddy" and age 3
    }
    @Test
    void testInitialValues() {
        assertEquals("Buddy", dog.getName()); // Check initial name
        assertEquals(PetType.Dog, dog.getPetType()); // Check initial type
        assertEquals(3, dog.getAge()); // Check initial age
        assertEquals(63, dog.getHealth()); // Check initial health
        assertEquals(54, dog.getHappiness()); // Check initial happiness
        assertEquals(65, dog.getHunger()); // Check initial hunger
        assertFalse(dog.isDead()); // Check initial death status
    }
    /**
     * Test the Speak method when the dog is alive and happy.
     * This test ensures that when the dog's happiness is above 20, it returns "Bark".
     */
    @Test
    public void testSpeakHappy() {
        dog.setHappiness(50); // Set happiness to a value greater than 20
        assertEquals("Bark", dog.speak(), "Expected the dog to bark when happiness is above 20."); // Verify output
    }

    /**
     * Test the Speak method when the dog is alive but unhappy.
     * This test ensures that when the dog's happiness is 20 or less, it returns "Grrrrr".
     */
    @Test
    public void testSpeakUnhappy() {
        dog.setHappiness(15); // Set happiness to a value less than or equal to 20
        assertEquals("Grrrrr", dog.speak(), "Expected the dog to growl when happiness is 20 or less."); // Verify output
    }

    /**
     * Test the Speak method when the dog is dead.
     * This test ensures that when the dog's health is 0 (indicating it is dead), it returns "I am Dead".
     */
    @Test
    public void testSpeakDead() {
        dog.setHealth(0); // Set health to 0 to simulate death
        assertEquals("The dog is dead. Nothing happens.", dog.speak(), "Expected the dog to say 'I am Dead' when health is 0."); // Verify output
    }

    /**
     * Test the Feed method.
     * This test ensures that feeding the dog correctly updates its hunger, health, and happiness.
     */
    @Test
    public void testFeed() {
        dog.setHunger(50); // Set hunger level to 50
        dog.feed(); // Feed the dog

        // Verify that hunger decreases, health increases, and happiness increases
        assertEquals(25, dog.getHunger(), "Expected hunger to decrease by 10 after feeding."); 
        assertEquals(68, dog.getHealth(), "Expected health to increase by 5 after feeding."); 
        assertEquals(69, dog.getHappiness(), "Expected happiness to increase by 15 after feeding.");
    }

    /**
     * Test the Play method.
     * This test ensures that playing with the dog correctly updates its hunger, health, and happiness.
     */
    @Test
    public void testPlay() {
        dog.setHunger(50); // Set hunger level to 50
        dog.play(); // Play with the dog

        // Verify that hunger increases, health increases, and happiness increases
        assertEquals(61, dog.getHunger(), "Expected hunger to increase by 15 after playing.");
        assertEquals(68, dog.getHealth(), "Expected health to increase by 10 after playing.");
        assertEquals(69, dog.getHappiness(), "Expected happiness to increase by 20 after playing.");
    }

    /**
     * Test the Heal method.
     * This test ensures that healing the dog correctly updates its hunger, health, and happiness.
     */
    @Test
    public void testHeal() {
        dog.setHunger(50); // Set hunger level to 50
        dog.heal(); // Heal the dog

        // Verify that hunger increases, health increases, and happiness increases
        assertEquals(59, dog.getHunger(), "Expected hunger to increase by 15 after healing.");
        assertEquals(78, dog.getHealth(), "Expected health to increase by 10 after healing.");
        assertEquals(59, dog.getHappiness(), "Expected happiness to increase by 20 after healing.");
    }

    /**
     * Test the PassageOfTime method.
     * This test ensures that the passage of time correctly updates the dog's hunger, health, and happiness.
     */
    @Test
    public void testPassageOfTime() {
        dog.setHunger(50); // Set hunger level to 50
        dog.setHealth(50); // Set health level to 50
        dog.setHappiness(50); // Set happiness level to 50
        dog.passageOfTime(); // Simulate the passage of time

        // Verify that hunger increases, happiness decreases, and health decreases
        assertEquals(57, dog.getHunger(), "Expected hunger to increase by 10 after passage of time.");
        assertEquals(47, dog.getHealth(), "Expected health to decrease by 5 after passage of time.");
        assertEquals(45, dog.getHappiness(), "Expected happiness to decrease by 25 after passage of time.");
    }
}
