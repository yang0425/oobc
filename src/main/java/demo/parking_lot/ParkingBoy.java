package demo.parking_lot;

import java.util.Arrays;
import java.util.Optional;

class ParkingBoy extends AbstractParkingBoy {

    ParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    Optional<ParkingLot> findSuitableParkingLot() {
        return Arrays.stream(parkingLots).filter(ParkingLot::isAvailable).findFirst();
    }

}
