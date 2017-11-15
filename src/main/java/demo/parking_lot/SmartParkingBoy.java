package demo.parking_lot;

import java.util.Arrays;
import java.util.Optional;

import static java.util.Comparator.comparing;

class SmartParkingBoy extends AbstractParkingBoy {

    SmartParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    Optional<ParkingLot> findSuitableParkingLot() {
        return Arrays.stream(parkingLots).max(comparing(ParkingLot::getAvailableSpaces));
    }

}
