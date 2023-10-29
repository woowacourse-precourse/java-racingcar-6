package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.validate.InvalidInputException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final InvalidInputException invalidInputException = new InvalidInputException();
    private static final Cars cars = new Cars();

    public void run() {
        // 자동차 입력 안내 메세지 출력
        outputView.carNameInputGuide();

        // 자동차 이름 입력
        String inputCarNames = carNamesInput();

        // 자동차 객체 리스트 생성
        createCars(inputCarNames);

        // 시도할 횟수 입력 안내 메세지 출력
        outputView.timesInputGuide();

        // 시도할 횟수 입력
        int times = timesInput();

        // '실행 결과' 메세지 출력
        outputView.resultGuide();

        // 경주 시작
        for (int i = 0; i < times; i++) {
            startRacing();
        }

        outputView.printFinalWinner(formatWinnerNames(cars.getWinner()));
    }

    private void createCars(String inputCarNames) {
        List<Car> inputCarList = Arrays.stream(inputCarNames.split(",")).map(Car::new).collect(Collectors.toList());

        cars.addCars(inputCarList);
    }

    private void startRacing() {
        outputView.printSingleCarResult(cars.singleRoundResult());
    }

    private String carNamesInput() {
        String input = inputView.carNamesInput();
        invalidInputException.checkInput(input);
        return input;
    }

    private int timesInput() {
        String times = inputView.timesInput();
        invalidInputException.checkTimes(times);
        return Integer.parseInt(times);
    }

    private String formatWinnerNames(List<String> winnerNames) {
        return String.join(",", winnerNames);
    }
}
