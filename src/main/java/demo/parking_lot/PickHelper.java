package demo.parking_lot;

import demo.exception.CarNotFoundException;
import demo.model.Car;

class PickHelper {

    private final ParkingAble[] parkingAbles;

    PickHelper(ParkingAble... parkingAbles) {
        this.parkingAbles = parkingAbles;
    }

    Car pick(String ticket) {
        for (ParkingAble parkingAble : parkingAbles) {
            if (parkingAble.containsCar(ticket))
                return parkingAble.pick(ticket);
        }
        throw new CarNotFoundException();
    }
}