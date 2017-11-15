package demo.parking_lot;

import demo.model.Car;
import org.junit.Test;

import static org.junit.Assert.assertSame;

public class SuperParkingBoyTest {

    @Test
    public void should_park_to_second_parking_lot_when_second_parking_lot_has_more_vacancy_rate() {
        ParkingLot firstParkingLot = new ParkingLot(4);
        firstParkingLot.park(new Car("JA1"));
        firstParkingLot.park(new Car("JA2"));
        firstParkingLot.park(new Car("JA3"));
        ParkingLot secondParkingLot = new ParkingLot(2);
        secondParkingLot.park(new Car("JA4"));
        SuperParkingBoy parkingBoy = new SuperParkingBoy(firstParkingLot, secondParkingLot);
        Car car = new Car("JA2345");
        String ticket = parkingBoy.park(car);

        assertSame(car, secondParkingLot.pick(ticket));
    }

}
