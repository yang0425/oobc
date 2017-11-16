package demo.parking_lot;

import demo.exception.CarNotFoundException;
import demo.exception.ParkingLotFullException;
import demo.model.Car;

import java.util.Optional;

public abstract class AbstractParkingBoy {

    ParkingLot[] parkingLots;

    AbstractParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots = parkingLots;
    }

    public String park(Car car) {
        Optional<ParkingLot> parkingLot = findSuitableParkingLot();
        if (parkingLot.isPresent()) {
            return parkingLot.get().park(car);
        } else {
            throw new ParkingLotFullException();
        }
    }

    public Car pick(String ticket) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.containsCar(ticket))
                return parkingLot.pick(ticket);
        }
        throw new CarNotFoundException();
    }

    abstract Optional<ParkingLot> findSuitableParkingLot();

}
