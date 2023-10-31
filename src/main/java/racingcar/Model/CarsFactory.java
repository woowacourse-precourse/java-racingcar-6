package racingcar.Model;


public class CarsFactory {

    public Cars generateCars(String[] carNames) {
        Cars cars = new Cars();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.addCar(car);
        }
        return cars;
    }

}
