package factory;

import domain.Car;
import domain.CarLocation;
import domain.CarName;
import domain.ForwardStrategy;

public class CarFactory {

    public static Car createCar(String name, int location,ForwardStrategy forwardStrategy) {
        CarName carName = new CarName(name);
        CarLocation carLocation = new CarLocation(location);

        return Car.of(carName, carLocation,forwardStrategy);
    }
}
