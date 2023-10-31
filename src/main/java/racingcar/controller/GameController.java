package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.NumberGenerator;
import racingcar.model.Race;
import racingcar.utils.UserInputManager;
import racingcar.view.RaceView;

import java.util.List;
import java.util.stream.Collectors;

public class GameController {

    private List<Car> cars;
    private Race race;
    private RaceView raceView;
    private final NumberGenerator numberGenerator;
    private final Judgement judgement;
    private final UserInputManager userInputManager;

    List<String> carNames;
    List<Integer> randomNumbers;
    List<Integer> carBoost;
    int attempt;


    public GameController() {   //생성자
        this.userInputManager = new UserInputManager();
        this.numberGenerator = new NumberGenerator();
        this.judgement = new Judgement();
    }

    private void initializeGame() {
        carNames = userInputManager.getCarNames();
        cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        attempt = userInputManager.getAttempts();
    }

    public void startGame() {
        initializeGame();
        conductRaces();
        determineWinner();
    }

    public void conductRaces() {

    }

    public void determineWinner() {

    }


}
