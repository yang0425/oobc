package demo.parking_lot;

import demo.exception.CarNotFoundException;
import demo.exception.ParkingLotFullException;
import demo.model.Car;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static util.exception.AssertJThrowableAssert.assertThrown;

@RunWith(JUnitParamsRunner.class)
public class ParkingLotTest {

    @Test
    @Parameters({"JA123", "JA124"})
    public void should_get_ticket_when_park_a_car_in_one_parking_lot_with_one_available_parking_space(String number) {
        ParkingLot parkingLot = new ParkingLot(1);
        Car car = new Car(number);

        String ticket = parkingLot.park(car);

        assertEquals(number, ticket);
    }

    @Test
    @Parameters({"0", "1", "2"})
    public void should_pick_up_the_same_car_when_it_has_parked_in_parking_lot(int num) {
        ParkingLot parkingLot = new ParkingLot(3);
        Car car = new Car("JA123");
        String ticket = "";
        for (int i = 0; i < 3; i++) {
            if (i == num) {
                ticket = parkingLot.park(car);
            } else {
                parkingLot.park(new Car(String.valueOf(Math.random())));
            }
        }

        assertSame(car, parkingLot.pick(ticket));
    }

    @Test
    public void should_not_parking_a_car_into_a_full_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car("JA123"));

        assertThrown(() -> parkingLot.park(new Car("JA124")))
                .isInstanceOf(ParkingLotFullException.class)
                .hasMessage("the parking lot is full!");
    }

    @Test
    public void should_not_pick_up_a_car_which_is_not_exist_in_the_parking_lot() {
        ParkingLot parkingLot = new ParkingLot(1);
        parkingLot.park(new Car("JA123"));

        assertThrown(() -> parkingLot.pick("JA124"))
                .isInstanceOf(CarNotFoundException.class)
                .hasMessage("the car is not exist in the parking lot!");
    }

    @Test
    public void should_not_pick_up_a_car_twice() {
        ParkingLot parkingLot = new ParkingLot(1);
        String ticket = parkingLot.park(new Car("JA123"));
        parkingLot.pick(ticket);

        assertThrown(() -> parkingLot.pick(ticket))
                .isInstanceOf(CarNotFoundException.class)
                .hasMessage("the car is not exist in the parking lot!");
    }

}
