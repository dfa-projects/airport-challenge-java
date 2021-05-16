package airport.java.challenge;

import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AirportTest {
    Airport airport;
    Plane mockedPlane1;
    Plane mockedPlane2;

    @BeforeEach
    public void setup() {
        mockedPlane1 = mock(Plane.class);
        mockedPlane2 = mock(Plane.class);
        when(mockedPlane1.getName()).thenReturn("Plane 1");
        when(mockedPlane2.getName()).thenReturn("Plane 2");
    }

    @Test
    public void testDefaultCapacity() {
        airport = new Airport();
        assertEquals( 5, airport.capacity);
    }

    @Test
    public void testOverride() {
        airport = new Airport();
        assertEquals(10, airport.override(10));
    }

    @Test
    public void testCanLandPlane() {
        airport = new Airport();
        mockedPlane1 = mock(Plane.class);
        when(mockedPlane1.getName()).thenReturn("Plane 1");
        assertEquals("Plane 1 has landed.", airport.land(mockedPlane1.getName()));
    }

    @AfterEach
    void tearDown() {
    }
}