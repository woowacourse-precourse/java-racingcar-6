package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.NumberGenerator;
import racingcar.utils.UserInputManager;
import racingcar.view.RaceView;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {
    private final String executionResult = "실행 결과";
    private final Judgement judgement;
    private final UserInputManager userInputManager;
    List<String> carNames;
    List<Integer> carRandomNumbers;
    List<Car> sortedCars;
    List<String> raceWinner;
    int attempt;
    private List<Car> cars;
    private final RaceView raceView;
    private NumberGenerator numberGenerator;


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
        System.out.println(executionResult);
        for (int i = 0; i < attempt; i++) {
            numberGenerator = new NumberGenerator(cars.size());
            carRandomNumbers = numberGenerator.getRandomNumbers();
            int carIndex = 0;
            for (Car car : cars) {
                car.moveForward(carRandomNumbers.get(carIndex));
                carIndex++;
            }

            raceView.displayRaceResults(cars);
        }
    }

    public void determineWinner() {
        sortedCars = cars.stream()
                .sorted((car1, car2) -> Integer.compare(car2.getCarScore(), car1.getCarScore()))   //carScore 내림차순으로 Car 객체정렬
                .collect(Collectors.toList());
        raceWinner = judgement.determineWinner(sortedCars);
        raceView.displayWinner(raceWinner);

    }


}
