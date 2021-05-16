package airport.java.challenge;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
    Plane plane;

    @Test
    public void canGetPlane() {
        plane = new Plane("Plane 1");
        assertEquals("Plane 1", plane.name);
    }
}