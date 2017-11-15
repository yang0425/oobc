package demo.parking_lot;

import demo.exception.ParkingLotFullException;
import demo.model.Car;

import java.util.Arrays;
import java.util.Optional;

public abstract class AbstractParkingBoy implements ParkingAble {

    private final PickHelper pickHelper;
    ParkingLot[] parkingLots;

    AbstractParkingBoy(ParkingLot... parkingLots) {
        this.parkingLots = parkingLots;
        this.pickHelper = new PickHelper(parkingLots);
    }

    @Override
    public String park(Car car) {
        Optional<ParkingLot> parkingLot = findSuitableParkingLot();
        if (parkingLot.isPresent()) {
            return parkingLot.get().park(car);
        } else {
            throw new ParkingLotFullException();
        }
    }

    @Override
    public Car pick(String ticket) {
        return pickHelper.pick(ticket);
    }

    @Override
    public boolean isNotFull() {
        return Arrays.stream(parkingLots).anyMatch(ParkingLot::isNotFull);
    }

    @Override
    public boolean containsCar(String ticket) {
        return Arrays.stream(parkingLots).anyMatch(parkingLot -> parkingLot.containsCar(ticket));
    }

    abstract Optional<ParkingLot> findSuitableParkingLot();

}
