package demo.parking_lot;

import demo.model.Car;

public interface ParkingAble {

    String park(Car car);

    Car pick(String ticket);

    boolean isNotFull();

    boolean containsCar(String ticket);

}
