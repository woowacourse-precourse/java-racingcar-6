package factory;

import domain.Car;
import domain.CarLocation;
import domain.CarName;
import domain.MoveStrategy;

public class CarFactory {

    public static Car createCar(String name, int location, MoveStrategy moveStrategy) {
        CarName carName = new CarName(name);
        CarLocation carLocation = new CarLocation(location);

        return Car.of(carName, carLocation,moveStrategy);
    }
}
