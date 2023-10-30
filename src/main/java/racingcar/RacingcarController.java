package racingcar;

public class RacingcarController {
    Input input = new Input();
    Cars cars = new Cars();

    public void playRacingcarGame() {
        String carsName = inputCarsName();
        addCars(splitCarsName(carsName));
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
