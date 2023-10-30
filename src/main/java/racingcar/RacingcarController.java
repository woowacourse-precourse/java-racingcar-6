package racingcar;

public class RacingcarController {
    Input input = new Input();
    Cars cars = new Cars();

    public void playRacingcarGame() {
        String carsName = inputCarsName();
        addCars(splitCarsName(carsName));
    }

    private String inputCarsName() {
        return input.inputCarName();
    }

    private String[] splitCarsName(String carsName) {
        return carsName.split(",");
    }

    private void addCars(String[] CarsName) {
        for (String name: CarsName) {
            Car car = new Car(name.trim(), 0);
            cars.addCarList(car);
        }
    }
}
