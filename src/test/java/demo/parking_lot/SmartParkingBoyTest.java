package demo.parking_lot;

import demo.model.Car;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class SmartParkingBoyTest {

    @Test
    public void should_park_to_second_parking_lot_when_second_parking_lot_has_more_available_spaces() {
        ParkingLot firstParkingLot = new ParkingLot(1);
        ParkingLot secondParkingLot = new ParkingLot(2);
        SmartParkingBoy parkingBoy = new SmartParkingBoy(firstParkingLot, secondParkingLot);
        Car car = new Car("JA2345");
        String ticket = parkingBoy.park(car);

        assertSame(car, secondParkingLot.pick(ticket));
    }

}
