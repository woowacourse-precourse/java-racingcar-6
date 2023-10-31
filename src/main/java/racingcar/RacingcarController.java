package racingcar;

public class RacingcarController {
    Input input = new Input();
    Cars cars = new Cars();
    Exception exception = new Exception();

    public void playRacingcarGame() {
        String carsName = inputCarsName();
        String[] splitCarName = splitCarsName(carsName);
        exception.validateNumberOfCarName(splitCarName);
        addCars(splitCarName);
    }

    public String inputCarsName() {
        return input.inputCarName();
    }

    public String[] splitCarsName(String carsName) {
        return carsName.split(",");
    }

    public void addCars(String[] CarsName) {
        for (String name: CarsName) {
            Car car = new Car(name.trim(), 0);
            cars.addCarList(car);
        }
    }
}
