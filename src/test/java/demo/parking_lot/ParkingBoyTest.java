package demo.parking_lot;

import demo.model.Car;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

public class ParkingBoyTest {

    @Test
    public void should_get_ticket_when_park_a_car_in_one_parking_lot_with_one_available_parking_space() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);

        String ticket = parkingBoy.park(new Car("JA2345"));

        assertEquals("JA2345", ticket);
    }

    @Test
    public void should_pick_up_the_same_car_when_it_has_parked_in_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLot);
        Car car = new Car("JA2345");
        String ticket = parkingBoy.park(car);

        assertSame(car, parkingBoy.pick(ticket));
    }

    @Test
    public void should_park_to_first_parking_lot_when_first_parking_lot_is_not_full() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);
        Car car = new Car("JA2345");
        String ticket = parkingBoy.park(car);

        assertSame(car, firstParkingLot.pick(ticket));
    }

    @Test
    public void should_park_to_second_parking_lot_when_first_parking_lot_is_full() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        firstParkingLot.park(new Car("JA2344"));
        ParkingLot secondParkingLot = new ParkingLot(1);
        ParkingBoy parkingBoy = new ParkingBoy(firstParkingLot, secondParkingLot);
        Car car = new Car("JA2345");
        String ticket = parkingBoy.park(car);

        assertSame(car, secondParkingLot.pick(ticket));
    }

}
