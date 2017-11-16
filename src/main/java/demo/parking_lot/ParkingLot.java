package demo.parking_lot;

import demo.exception.CarNotFoundException;
import demo.exception.ParkingLotFullException;
import demo.model.Car;

import java.util.ArrayList;
import java.util.List;

class ParkingLot {

    private List<Car> cars = new ArrayList<>();
    private int capacity;

    ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public String park(Car car) {
        if (cars.size() >= capacity) {
            throw new ParkingLotFullException();
        }
        cars.add(car);
        return car.getNumber();
    }

    public Car pick(String ticket) {
        for (Car car : cars) {
            if (car.getNumber().equals(ticket)) {
                cars.remove(car);
                return car;
            }
        }
        throw new CarNotFoundException();
    }

    public boolean isAvailable() {
        return getAvailableSpaces() > 0;
    }

    public boolean containsCar(String ticket) {
        return cars.stream().anyMatch(car -> car.getNumber().equals(ticket));
    }

    int getAvailableSpaces() {
        return capacity - cars.size();
    }

    double getVacancyRate() {
        return getAvailableSpaces() / (double) capacity;
    }
}
