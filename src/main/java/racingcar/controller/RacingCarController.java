package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.utils.RandomUtils;
import racingcar.validate.InvalidInputException;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarController {
    private static final int RANDOM_START_NUMBER = 0;
    private static final int RANDOM_LAST_NUMBER = 9;
    private static final OutputView outputView = new OutputView();
    private static final InputView inputView = new InputView();
    private static final InvalidInputException invalidInputException = new InvalidInputException();
    private static final Cars cars = new Cars();
    private static final RandomUtils randomUtils = new RandomUtils();

    public void run() {
        // 자동차 입력 안내 메세지 출력
        outputView.carNameInputMessage();

        // 자동차 이름 입력
        String inputCarNames = carNamesInput();

        // 자동차 객체 리스트 생성
        createCars(inputCarNames);

        // 시도할 횟수 입력 안내 메세지 출력
        outputView.timesInputMessage();

        // 시도할 횟수 입력
        int times = timesInput();

        // '실행 결과' 메세지 출력
        outputView.resultMessage();

        // 경주 시작
        for(int i=0; i<times; i++) {
            startRacing();
        }

        cars.setWinner();

        // '최종 우승자 : ' 메세지 출력
        outputView.winnerMessage();

        // 최종 우승자 출력
        printFinalWinner(cars.getWinner());
    }

    private void createCars(String inputCarNames) {
        List<Car> inputCarList = Arrays.stream(inputCarNames.split(","))
                .map(Car::new)
                .collect(Collectors.toList());

        cars.addCars(inputCarList);
    }

    private void startRacing() {
        for (Car car : cars.getCarList()) {
            cars.oneResult(car, randomUtils.getRandomNumber(RANDOM_START_NUMBER, RANDOM_LAST_NUMBER));
            outputView.CarNameOutput(car.getName());
            outputView.resultCountOutput(car.getForwardCount());
        }
        outputView.printOutput();
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

    private void printFinalWinner(List<Car> winnerList) {
        for(int i = 0; i< winnerList.size(); i++) {
            if(i == 0) {
                outputView.Winner(winnerList.get(i).getName());
            }
            if(i > 0) {
                outputView.Winners(winnerList.get(i).getName());
            }
        }
        outputView.printOutput();
    }
}
