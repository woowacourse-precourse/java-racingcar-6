package racingcar.controller;

import racingcar.view.InputView;
import racingcar.view.OutputView;
import racingcar.util.InputValidation;
import racingcar.domain.Car;
import racingcar.util.RandomNumberGenerator;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GameController {
    int totalRound;
    List<Car> cars = new ArrayList<>();
    List<String> carNames = new ArrayList<>();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    InputValidation inputValidation = new InputValidation();
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
    public void startGame() {

        // 자동차 이름 입력 요청
        String inputCarNames = inputView.CarName();
        inputValidation.isVaildCarName(inputCarNames);
        // 시도할 회수 입력 요청
        String inputGameRound = inputView.GameRound();
        // 입력값 검증
        inputValidation.isVaildGameRound(inputGameRound);

        setGame(inputCarNames, inputGameRound);
        playGame();
    }
    public void playGame() {
        outputView.result();
        // 회차별 게임 진행
        int runRound= 0;
        while (runRound < totalRound) {
            playCarRace();
            outputView.lineBreak();
            runRound++;
        }
        // endGame();
    }

    private void playCarRace() {
            for(Car car : cars) {
                // 1.난수 발생
                if (randomNumberGenerator.getRandomNumber() > 4) {
                    // 2.자동차 이동
                    car.moveForward();
                }
                String printDinstance = MarkToMove(car.getMoveDistance());
                outputView.resultByRound(car.getName(), printDinstance);
            }
    }

    private String MarkToMove(Integer moveDistance) {
        String marking = "-";
        return marking.repeat(moveDistance);
    }

    public void endGame() {
        // 최종 우승자 선발
        // 최종 우승자 출력
    }

    private void setGame(String inputCarNames, String inputGameRound) {
        setCars(inputCarNames);
        setRound(inputGameRound);
    }

    private void setCars(String inputCarNames) {
        String[] arrCarNames = inputCarNames.split(",");
        this.carNames = Arrays.asList(arrCarNames);

        for (String carName: carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
    }
    private void setRound(String inputGameRound) {
        this.totalRound = Integer.parseInt(inputGameRound);
    }


}
