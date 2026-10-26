package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GT4500Test {

    private GT4500 ship;

    @BeforeEach
    public void init() {
        this.ship = new GT4500();
    }

    @Test
    void fireTorpedo_Single_Success() {
        // Arrange

        // Act
        boolean result = ship.fireTorpedo(FiringMode.SINGLE);

        // Assert
        assertEquals(true, result);
    }

    @Test
    void fireTorpedo_All_Success() {
        // Arrange

        // Act
        boolean result = ship.fireTorpedo(FiringMode.ALL);

        // Assert
        assertEquals(true, result);
    }
    
    @Test
    void fireTorpedo_Single_AlternatesStores() {
        ship = new GT4500(2, 0.0, 2, 0.0);

        assertTrue(ship.fireTorpedo(FiringMode.SINGLE));
        assertTrue(ship.fireTorpedo(FiringMode.SINGLE));
    }

    @Test
    void fireTorpedo_Single_PrimaryEmpty() {
        ship = new GT4500(0, 0.0, 1, 0.0);

        assertTrue(ship.fireTorpedo(FiringMode.SINGLE));
        assertFalse(ship.fireTorpedo(FiringMode.SINGLE));
    }

    @Test
    void fireTorpedo_Single_SecondaryEmpty() {
        ship = new GT4500(2, 0.0, 0, 0.0);

        assertTrue(ship.fireTorpedo(FiringMode.SINGLE));
        assertTrue(ship.fireTorpedo(FiringMode.SINGLE));
        assertFalse(ship.fireTorpedo(FiringMode.SINGLE));
    }

    @Test
    void fireTorpedo_Single_FiringFails() {
        ship = new GT4500(1, 1.0, 1, 0.0);

        assertFalse(ship.fireTorpedo(FiringMode.SINGLE));
    }

    @Test
    void fireTorpedo_All_PrimaryOnly() {
        ship = new GT4500(1, 0.0, 0, 0.0);

        assertTrue(ship.fireTorpedo(FiringMode.ALL));
    }

    @Test
    void fireTorpedo_All_SecondaryOnly() {
        ship = new GT4500(0, 0.0, 1, 0.0);

        assertTrue(ship.fireTorpedo(FiringMode.ALL));
    }

    @Test
    void fireTorpedo_All_BothEmpty() {
        ship = new GT4500(0, 0.0, 0, 0.0);

        assertFalse(ship.fireTorpedo(FiringMode.ALL));
    }

    @Test
    void fireTorpedo_All_BothFail() {
        ship = new GT4500(1, 1.0, 1, 1.0);

        assertFalse(ship.fireTorpedo(FiringMode.ALL));
    }

}
