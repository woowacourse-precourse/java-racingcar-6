package racingcar.controller;

import static racingcar.view.GameView.inputCarName;
import static racingcar.view.GameView.inputTrialNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.view.GameView;

public class GameController {
    private Game model;
    private GameView view;

    public GameController(Game model, GameView view) {
        this.model = model;
        this.view = view;
    }

    public void run() {
        List<String> carNames = splitCarNames(inputCarName());
        System.out.println(carNames);

        List<Car> cars = createCarObject(carNames);
        model.setCars(cars);

        int trialNumber = parseInteger(inputTrialNumber());
        System.out.println(trialNumber);

        gameStart(trialNumber, cars);
    }

    private List<String> splitCarNames(String input) {
        return new ArrayList<>(Arrays.asList(input.split(",")));
    }

    private List<Car> createCarObject(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName, 0);
            cars.add(car);
        }
        return cars;
    }

    private static int parseInteger(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            // 정수로 변환할 수 없는 경우 예외 처리
            return 0; // 또는 다른 기본값을 반환하거나 예외를 던질 수 있습니다.
        }
    }

    private void gameStart(int trialNumber, List<Car> cars) {
        for (int i = 0; i < trialNumber; i++) {
            System.out.println(i);
        }
    }

}
