package wcci.org.virtualpet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import wcci.org.virtualpet.Enums.*;
import wcci.org.virtualpet.Exceptions.*;
import wcci.org.virtualpet.Models.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the PetModel class.
 */
class PetModelTest {
    private PetModel pet;

    // Concrete subclass for testing
    private class TestPet extends PetModel {
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

    /**
     * Sets up a new pet instance before each test.
     * @throws ValidateException 
     */
    @BeforeEach
    void setUp() throws ValidateException {
        pet = new TestPet("Buddy", PetType.Dog, 3);
    }

    /**
     * Tests the initial values of the pet.
     */
    @Test
    void testInitialValues() {
        assertEquals("Buddy", pet.getName()); // Check initial name
        assertEquals(PetType.Dog, pet.getPetType()); // Check initial type
        assertEquals(3, pet.getAge()); // Check initial age
        assertEquals(63, pet.getHealth()); // Check initial health
        assertEquals(54, pet.getHappiness()); // Check initial happiness
        assertEquals(65, pet.getHunger()); // Check initial hunger
        assertFalse(pet.isDead()); // Check initial death status
    }

    /**
     * Checks the name for validation Exception
     * 
     * @throws ValidateException
     */
    @Test
    void testSetName() throws ValidateException {
        assertThrows(ValidateException.class, () -> pet.setName("")); //Checks for empty
        assertThrows(ValidateException.class, () -> pet.setName(null));//Checks for null
        String name = String.format("%-150s", " "); //Fills a string with 150 characters
        assertThrows(ValidateException.class, () -> pet.setName(name));//Checks for too long
        pet.setName("Spot"); //populate with a valid value
        assertEquals("Spot", pet.getName()); // Check Name for correct value

    }

    /**
     * Tests the setHealth method.
     * 
     * @throws ValidateException
     */
    @Test
    void testSetAge() throws ValidateException {
        assertThrows(ValidateException.class, () -> pet.setAge(0)); //Checks for 0
        assertThrows(ValidateException.class, () -> pet.setAge(100)); //Checks for above 20
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
    void testSetHunger() {
        pet.setHunger(50);
        assertEquals(50, pet.getHunger()); // Check hunger within bounds

        pet.setHunger(150);
        assertEquals(100, pet.getHunger()); // Check hunger upper bound
        assertTrue(pet.isDead()); // Check death status
        assertEquals(DeathBy.Hunger, pet.getDeathBy()); // Check death reason

        pet.setHunger(-10);
        assertEquals(0, pet.getHunger()); // Check hunger lower bound
    }

    /**
     * Tests the Feed method.
     */
    @Test
    void testFeed() {
        pet.feed();
        assertEquals(40, pet.getHunger()); // Check decreased hunger
        assertEquals(68, pet.getHealth()); // Check increased health
        assertEquals(69, pet.getHappiness()); // Check increased happiness
    }

    /**
     * Tests the Play method.
     */
    @Test
    void testPlay() {
        pet.play();
        assertEquals(76, pet.getHunger()); // Check increased hunger
        assertEquals(68, pet.getHealth()); // Check increased health
        assertEquals(69, pet.getHappiness()); // Check increased happiness
    }

    /**
     * Tests the Heal method.
     */
    @Test
    void testHeal() {
        pet.heal();
        assertEquals(74, pet.getHunger()); // Check increased hunger
        assertEquals(78, pet.getHealth()); // Check increased health
        assertEquals(59, pet.getHappiness()); // Check increased happiness
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
        pet.setHunger(40);
        pet.setHappiness(40);
        pet.setHealth(40);

        pet.passageOfTime();

        assertEquals(47, pet.getHunger()); // Check hunger after time passage
        assertEquals(35, pet.getHappiness()); // Check happiness after time passage
        assertEquals(37, pet.getHealth()); // Check health after time passage
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
        assertEquals("This pet is so sad. If you don't do something he may die from boredom.", pet.checkHappiness()); // Check happiness status

        pet.setHappiness(50);
        assertEquals("This pet seems pretty happy.", pet.checkHappiness()); // Check happy pet
    }
}
