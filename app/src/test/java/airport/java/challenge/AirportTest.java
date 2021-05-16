package airport.java.challenge;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class AirportTest {
    Airport airport;
    Plane mockedPlane1;
    Plane mockedPlane2;

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
    public void testLandPlane() {
        airport = new Airport();
        mockedPlane1 = mock(Plane.class);
        when(mockedPlane1.getName()).thenReturn("Plane 1");
        airport.land(mockedPlane1.getName());
        assertEquals(1, airport.hangar.size());
    }

    @Test
    public void testLandPlaneMessage() {
        airport = new Airport();
        mockedPlane1 = mock(Plane.class);
        when(mockedPlane1.getName()).thenReturn("Plane 1");
        assertEquals("Plane 1 has landed.", airport.land(mockedPlane1.getName()));
    }

    @Test
    public void testAlreadyLanded() {
        airport = new Airport();
        mockedPlane1 = mock(Plane.class);
        when(mockedPlane1.getName()).thenReturn("Plane 1");
        airport.land(mockedPlane1.getName());
        assertEquals("This plane has already landed.", airport.land(mockedPlane1.getName()));
    }

    @Test
    public void testCannotLandWhenFull() {
        airport = new Airport();
        airport.override(1);
        mockedPlane1 = mock(Plane.class);
        when(mockedPlane1.getName()).thenReturn("Plane 1");
        airport.land(mockedPlane1.getName());
        mockedPlane2 = mock(Plane.class);
        when(mockedPlane2.getName()).thenReturn("Plane 2");
        assertEquals("Cannot land plane. Hangar is full.", airport.land(mockedPlane2.getName()));
    }

    @Test
    public void testTakeOff() {
        airport = new Airport();
        mockedPlane1 = mock(Plane.class);
        when(mockedPlane1.getName()).thenReturn("Plane 1");
        airport.land(mockedPlane1.getName());
        airport.takeOff(mockedPlane1.getName());
        assertEquals(0, airport.hangar.size());
    }

    @Test
    public void testTakeOffMessage() {
        airport = new Airport();
        mockedPlane1 = mock(Plane.class);
        when(mockedPlane1.getName()).thenReturn("Plane 1");
        airport.land(mockedPlane1.getName());
        assertEquals("Plane 1 has left the airport.", airport.takeOff(mockedPlane1.getName()));
    }

    @Test
    public void testAlreadyTakenOff() {
        airport = new Airport();
        mockedPlane1 = mock(Plane.class);
        when(mockedPlane1.getName()).thenReturn("Plane 1");
        assertEquals("This plane has already taken off.", airport.takeOff(mockedPlane1.getName()));
    }
}