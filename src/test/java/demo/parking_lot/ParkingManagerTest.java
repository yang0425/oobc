package demo.parking_lot;

import demo.model.Car;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ParkingManagerTest {

    @Test
    public void should_get_ticket_when_park_a_car_in_one_parking_lot_with_one_available_parking_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(parkingLot);

        String ticket = parkingManager.park(new Car("JA2345"));

        assertEquals("JA2345", ticket);
    }

    @Test
    public void should_pick_up_the_same_car_when_it_has_parked_in_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingManager parkingManager = new ParkingManager(parkingLot);
        Car car = new Car("JA2345");
        String ticket = parkingManager.park(car);

        assertSame(car, parkingManager.pick(ticket));
    }

    @Test
    public void should_get_ticket_when_park_a_car_by_paring_boy() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        ParkingManager parkingManager = new ParkingManager(parkingBoy);

        String ticket = parkingManager.park(new Car("JA2345"));

        assertEquals("JA2345", ticket);
    }

    @Test
    public void should_get_ticket_when_park_a_car_by_paring_boy_and_managed_parking_lot_is_full() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        firstParkingLot.park(new Car("JA1"));
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(secondParkingLot);
        ParkingManager parkingManager = new ParkingManager(firstParkingLot, parkingBoy);

        String ticket = parkingManager.park(new Car("JA2345"));

        assertEquals("JA2345", ticket);
    }

}
