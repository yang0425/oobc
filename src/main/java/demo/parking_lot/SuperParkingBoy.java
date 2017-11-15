package demo.parking_lot;

import java.util.Arrays;
import java.util.Optional;

import static java.util.Comparator.comparing;

class SuperParkingBoy extends AbstractParkingBoy {

    SuperParkingBoy(ParkingLot... parkingLots) {
        super(parkingLots);
    }

    @Override
    Optional<ParkingLot> findSuitableParkingLot() {
        return Arrays.stream(parkingLots).max(comparing(ParkingLot::getVacancyRate));
    }

}
