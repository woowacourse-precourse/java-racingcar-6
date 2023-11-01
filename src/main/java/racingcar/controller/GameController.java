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
    List<Integer> carBoosts;
    int attempt;


    public GameController() {   //생성자
        userInputManager = new UserInputManager();
        numberGenerator = new NumberGenerator(cars.size());
        judgement = new Judgement();
    }

    private void initializeGame() {
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
        for(int i=0; i<attempt; i++) {
            carBoosts = numberGenerator.getRandomNumbers();
            race.updateCarsPositions(carBoosts);
            raceView.displayRaceProcess(cars);
        }


    }

    public void determineWinner() {

    }


}
