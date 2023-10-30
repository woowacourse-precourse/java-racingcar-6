package factory;

import domain.Car;
import domain.CarLocation;
import domain.CarName;

public class CarFactory {

    public static Car createCar(String name, int location) {
        CarName carName = new CarName(name);
        CarLocation carLocation = new CarLocation(location);

        return Car.of(carName, carLocation);
    }
}
