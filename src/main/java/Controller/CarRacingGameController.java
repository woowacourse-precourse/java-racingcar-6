package Controller;
import Model.Car;
import Model.Race;
import view.CarRacingGameView;

import java.util.ArrayList;
import java.util.List;
public class CarRacingGameController {
    private List<Car> cars;
    private int numOfAttempts;

    public CarRacingGameController(List<String> carNames) {
        this.cars = createCars(carNames);
        this.numOfAttempts = cars.size();
    }

    private List<Car> createCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public List<String> playGame() {
        Race race = new Race(cars, numOfAttempts);
        CarRacingGameView carView = new CarRacingGameView();
        System.out.println("\n실행 결과");
        for (int attempt = 1; attempt <= numOfAttempts; attempt++) {
            race.run();
            carView.printRoundResults(cars);
            System.out.println();
        }
        List<Car> winners = race.getWinners();
        List<String> winnerNames = new ArrayList<>();
        for (Car car : winners) {
            winnerNames.add(car.getName());
        }
        return winnerNames;
    }
}
