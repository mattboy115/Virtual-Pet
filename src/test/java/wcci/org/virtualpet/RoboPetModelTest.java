package wcci.org.virtualpet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import wcci.org.virtualpet.Enums.*;
import wcci.org.virtualpet.Exceptions.ValidateException;
import wcci.org.virtualpet.Models.*;

public class RoboPetModelTest {
    private RoboPetModel pet;

    // Concrete subclass for testing
    private class TestPet extends RoboPetModel {
        /**
         * Constructor for TestPet.
         *
         * @param name The name of the pet.
         * @param type The type of the pet.
         * @param age  The age of the pet.
         * @throws ValidateException 
         */
        public TestPet(String name, PetType type, int age) throws ValidateException {
            super(type, name, age);
        }

        /**
         * Returns a test speech for the pet.
         *
         * @return A string representing the pet's speech.
         */
        @Override
        public String speak() {
            return "Test pet speaks!";
        }
        @Override
        public String getStatus() {
            return "";
        }


    }

    @BeforeEach
    void setUp() throws ValidateException {
        pet = new TestPet("Buddy", PetType.RoboDog, 3);
    }

    /**
     * Tests the initial values of the pet.
     */
    @Test
    void testInitialValues() {
        assertEquals("Buddy", pet.getName()); // Check initial name
        assertEquals(PetType.RoboDog, pet.getPetType()); // Check initial type
        assertEquals(3, pet.getAge()); // Check initial age
        assertEquals(80, pet.getHealth()); // Check initial health
        assertEquals(60, pet.getHappiness()); // Check initial happiness
        assertEquals(60, pet.getBattery()); // Check initial battery
        assertEquals(20, pet.getOil()); // Check oil
        assertFalse(pet.isDead()); // Check initial death status
    }

    /**
     * Checks the name for validation Exception
     * 
     * @throws ValidateException
     */
    @Test
    void testSetName() throws ValidateException {
        assertThrows(ValidateException.class, () -> pet.setName("")); // Checks for empty
        assertThrows(ValidateException.class, () -> pet.setName(null));// Checks for null
        String name = String.format("%-150s", " "); // Fills a string with 150 characters
        assertThrows(ValidateException.class, () -> pet.setName(name));// Checks for too long
        pet.setName("Spot"); // populate with a valid value
        assertEquals("Spot", pet.getName()); // Check Name for correct value

    }

    /**
     * Tests the setHealth method.
     * 
     * @throws ValidateException
     */
    @Test
    void testSetAge() throws ValidateException {
        assertThrows(ValidateException.class, () -> pet.setAge(0)); // Checks for 0
        assertThrows(ValidateException.class, () -> pet.setAge(100)); // Checks for above 20
        pet.setAge(5); // populates with a correct value
        assertEquals(5, pet.getAge()); // Check health within bounds
    }

    /**
     * Tests the setHealth method.
     */
    @Test
    void testSetHealth() throws ValidateException {
        pet.setHealth(50);
        assertEquals(50, pet.getHealth()); // Check health within bounds

        pet.setHealth(150);
        assertEquals(100, pet.getHealth()); // Check health upper bound

        pet.setHealth(-10);
        assertEquals(0, pet.getHealth()); // Check health lower bound
        assertTrue(pet.isDead()); // Check death status
        assertEquals(DeathBy.Medical, pet.getDeathBy()); // Check death reason
    }

    /**
     * Tests the setHappiness method.
     */
    @Test
    void testSetHappiness() {
        pet.setHappiness(50);
        assertEquals(50, pet.getHappiness()); // Check happiness within bounds

        pet.setHappiness(150);
        assertEquals(100, pet.getHappiness()); // Check happiness upper bound

        pet.setHappiness(-10);
        assertEquals(0, pet.getHappiness()); // Check happiness lower bound
        assertTrue(pet.isDead()); // Check death status
        assertEquals(DeathBy.Boredom, pet.getDeathBy()); // Check death reason
    }

    /**
     * Tests the setHunger method.
     */
    @Test
    void testSetBattery() {
        pet.setBattery(50);
        assertEquals(50, pet.getBattery()); // Check hunger within bounds

        pet.setBattery(-50);
        assertEquals(0, pet.getBattery()); // Check hunger upper bound
        assertTrue(pet.isDead()); // Check death status
        assertEquals(DeathBy.LowBattery, pet.getDeathBy()); // Check death reason

        pet.setBattery(-10);
        assertEquals(0, pet.getBattery()); // Check hunger lower bound
    }

    /**
     * Tests the Feed method.
     */
    @Test
    void testFeed() {
        pet.feed();
        assertEquals(100, pet.getBattery()); // Check decreased hunger
        assertEquals(86, pet.getHealth()); // Check increased health
        assertEquals(72, pet.getHappiness()); // Check increased happiness
    }

    /**
     * Tests the Play method.
     */
    @Test
    void testPlay() {
        pet.play();
        assertEquals(44, pet.getBattery()); // Check increased hunger
        assertEquals(87, pet.getHealth()); // Check increased health
        assertEquals(83, pet.getHappiness()); // Check increased happiness
    }

    /**
     * Tests the Heal method.
     */
    @Test
    void testHeal() {
        pet.heal();
        assertEquals(55, pet.getBattery()); // Check increased battery
        assertEquals(97, pet.getHealth()); // Check increased health
        assertEquals(69, pet.getHappiness()); // Check increased happiness
    }

    /**
     * Tests the Speak method.
     */
    @Test
    void testSpeak() {
        assertEquals("Test pet speaks!", pet.speak()); // Check pet speech
    }

    /**
     * Tests the PassageOfTime method.
     */
    @Test
    void testPassageOfTime() {
        pet.setBattery(40);
        pet.setHappiness(40);
        pet.setHealth(40);

        pet.passageOfTime();

        assertEquals(31, pet.getBattery()); // Check hunger after time passage
        assertEquals(35, pet.getHappiness()); // Check happiness after time passage
        assertEquals(36, pet.getHealth()); // Check health after time passage
    }

    /**
     * Tests the CheckHealth method.
     */
    @Test
    void testCheckHealth() {
        pet.setHealth(10);
        assertEquals("This pet is very unhealthy. You should heal them.", pet.checkHealth()); // Check health status

        pet.setHealth(50);
        assertEquals("This pet is decently healthy overall.", pet.checkHealth()); // Check healthy pet
    }

    /**
     * Tests the CheckHappiness method.
     */
    @Test
    void testCheckHappiness() {
        pet.setHappiness(10);
        assertEquals("This pet is so sad. If you don't do something he may die from boredom.", pet.checkHappiness()); // Check
                                                                                                                      // happiness
                                                                                                                      // status

        pet.setHappiness(50);
        assertEquals("This pet seems pretty happy.", pet.checkHappiness()); // Check happy pet
    }
}
