package wcci.org.virtualpet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import wcci.org.virtualpet.Enums.*;
import wcci.org.virtualpet.Exceptions.ValidateException;
import wcci.org.virtualpet.Models.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for the CatModel class.
 */
class CatModelTest {
    private CatModel cat;

    /**
     * Sets up a new CatModel instance before each test.
     * @throws ValidateException 
     */
    @BeforeEach
    void setUp() throws ValidateException {
        cat = new CatModel("Whiskers", 2);
    }

    /**
     * Tests the initial values of the cat.
     */
    @Test
    void testInitialValues() {
        assertEquals("Whiskers", cat.getName()); // Check initial name
        assertEquals(PetType.Cat, cat.getPetType()); // Check initial type
        assertEquals(2, cat.getAge()); // Check initial age
        assertEquals(70, cat.getHealth()); // Check initial health
        assertEquals(80, cat.getHappiness()); // Check initial happiness
        assertEquals(42, cat.getHunger()); // Check initial hunger
        assertFalse(cat.isDead()); // Check initial death status
    }

    /**
     * Tests the Speak method for a dead cat.
     */
    @Test
    void testSpeakWhenDead() {
        cat.setHealth(0); // Set health to 0 to simulate death
        assertEquals("The cat is dead. Nothing happens.", cat.speak()); // Check speech for dead cat
    }

    /**
     * Tests the Speak method for a cat with low happiness.
     */
    @Test
    void testSpeakWhenUnhappy() {
        cat.setHappiness(15); // Set happiness to a low value
        assertEquals("Grrrrr", cat.speak()); // Check speech for unhappy cat
    }

    /**
     * Tests the Speak method for a happy cat.
     */
    @Test
    void testSpeakWhenHappy() {
        cat.setHappiness(50); // Set happiness to a high value
        assertEquals("Pur", cat.speak()); // Check speech for happy cat
    }

    /**
     * Tests the Feed method and its effect on the cat's state.
     */
    @Test
    void testFeed() {
        cat.feed();
        assertEquals(22, cat.getHunger()); // Check decreased hunger
        assertEquals(75, cat.getHealth()); // Check increased health
        assertEquals(100, cat.getHappiness()); // Check increased happiness
    }

    /**
     * Tests the Play method and its effect on the cat's state.
     */
    @Test
    void testPlay() {
        cat.play();
        assertEquals(52, cat.getHunger()); // Check increased hunger
        assertEquals(79, cat.getHealth()); // Check increased health
        assertEquals(100, cat.getHappiness()); // Check increased happiness
    }

    /**
     * Tests the Heal method and its effect on the cat's state.
     */
    @Test
    void testHeal() {
        cat.heal();
        assertEquals(50, cat.getHunger()); // Check increased hunger
        assertEquals(90, cat.getHealth()); // Check increased health
        assertEquals(88, cat.getHappiness()); // Check increased happiness
    }

    /**
     * Tests the PassageOfTime method and its effect on the cat's state.
     */
    @Test
    void testPassageOfTime() {
        cat.passageOfTime();
        assertEquals(48, cat.getHunger()); // Check hunger after time passage
        assertEquals(76, cat.getHappiness()); // Check happiness after time passage
        assertEquals(68, cat.getHealth()); // Check health after time passage
    }

    /**
     * Tests the CheckHealth method for a cat with low health.
     */
    @Test
    void testCheckHealthWhenUnhealthy() {
        cat.setHealth(10);
        assertEquals("This pet is very unhealthy. You should heal them.", cat.checkHealth()); // Check health status
    }

    /**
     * Tests the CheckHealth method for a healthy cat.
     */
    @Test
    void testCheckHealthWhenHealthy() {
        cat.setHealth(50);
        assertEquals("This pet is decently healthy overall." , cat.checkHealth()); // Check health status
    }

    /**
     * Tests the CheckHappiness method for a cat with low happiness.
     */
    @Test
    void testCheckHappinessWhenUnhappy() {
        cat.setHappiness(10);
        assertEquals("This pet is so sad. If you don't do something he may die from boredom.", cat.checkHappiness()); // Check happiness status
    }

    /**
     * Tests the CheckHappiness method for a happy cat.
     */
    @Test
    void testCheckHappinessWhenHappy() {
        cat.setHappiness(50);
        assertEquals("This pet seems pretty happy.", cat.checkHappiness()); // Check happiness status
    }

    // @Test
    // void testAddCat() {
    //     AdmissionDTO model = new AdmissionDTO("Narancia", 8, PetType.Cat);
    //     service.savePet(model);
    // }
}

