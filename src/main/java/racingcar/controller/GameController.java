package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.NumberGenerator;
import racingcar.utils.UserInputManager;
import racingcar.view.RaceView;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private List<Car> cars;
    private RaceView raceView;
    private NumberGenerator numberGenerator;
    private final Judgement judgement;
    private final UserInputManager userInputManager;

    List<String> carNames;
    List<Integer> carBoosts;
    List<Car> sortedCars;
    List<String> raceWinner;
    int attempt;



    public GameController() {   //생성자
        userInputManager = new UserInputManager();
        raceView = new RaceView();
        judgement = new Judgement();
    }

    private void initializeGame() {
        userInputManager.inputCarNames();
        userInputManager.inputAttempts();
        carNames = userInputManager.getCarNames();
        cars = carNames.stream().map(Car::new).collect(Collectors.toList());    //받은 자동차 이름으로 객체 각각 생성
        attempt = userInputManager.getAttempts();

    }

    public void startGame() {
        initializeGame();
        conductRaces();
        determineWinner();
    }

    public void conductRaces() {
        for (int i = 0; i < attempt; i++) {
            numberGenerator = new NumberGenerator(cars.size());
            carBoosts = numberGenerator.getRandomNumbers();
            int carIndex = 0;
            for (Car car : cars) {
                car.moveForward(carBoosts.get(carIndex));
                carIndex++;
            }
            raceView.displayRaceResults(cars);
        }
    }

    public void determineWinner() {
        sortedCars=cars.stream()
                .sorted((car1,car2)-> Integer.compare(car2.getCarBoost(),car1.getCarBoost()))   //carBoost 내림차순으로 Car 객체정렬
                .collect(Collectors.toList());
        raceWinner = judgement.determineWinner(sortedCars);
        raceView.displayWinner(raceWinner);

    }


}
