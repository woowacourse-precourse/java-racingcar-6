package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Cars;
import racingcar.model.Names;
import racingcar.util.Message;
import racingcar.util.Validation;
import racingcar.view.Input;
import racingcar.view.Output;

import java.util.Arrays;
import java.util.List;

public class RacingCarGame {
    private Cars cars;
    private Names names;

    public RacingCarGame() {
        this.cars = new Cars();
        this.names = new Names();
    }

    public void run() {
        //INIT
        Output.printMessage(Message.GAME_INIT);

        // 이름
        String carNames = Input.consoleInput();
        Validation.isValidCarNames(carNames);
        initCars(carNames);

        // 시도 회수
        Output.printMessage(Message.INPUT_ATTEMPT);
        String Number = Console.readLine();
        Validation.isValidNumber(Number);

        Output.printGap();
        Output.printMessage(Message.RESULT);

        int gameAttempt = Integer.parseInt(Number);

        //게임 실행
        while (gameAttempt > 0) {
            playOneWayGame();
            printOneWayGameResult();
            gameAttempt--;
        }

        //결과 생성
        printWinners();
    }

    private void initCars(String carNames) {
        names.initNames(carNames);
        cars.initCars(names);
    }
    private void printWinners() {
        List<String> winners = cars.getWinner();
        Output.printGameWinners(Message.WINNER, winners);
    }

    private void playOneWayGame() {
        cars.getRandomGameNumber();
        cars.processGameNumber();
    }
    private void printOneWayGameResult() {
        Output.printGameResult(cars);
    }
}
