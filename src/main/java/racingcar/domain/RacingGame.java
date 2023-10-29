package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.*;
import racingcar.utils.io.InputManager;
import racingcar.utils.io.OutputManager;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    List<Car> cars = new ArrayList<>();
    int rounds = 0;

    public void run() {
        // 입력 & 검증
        String carNamesInput = InputManager.receiveCarName();
        Validator.validateCarNames(carNamesInput);

        String roundNumberInput = InputManager.receiveRoundNumber();
        Validator.validateRoundNumber(roundNumberInput);

        // 초기화
        List<String> names = Parser.parseStringList(carNamesInput);
        names.stream().forEach(name -> {
            cars.add(new Car(name));
        });
        rounds = Parser.parseInt(roundNumberInput);

        // 자동차 경주 과정 출력
        OutputManager.printResultMessage();
        for (int i = 0; i < rounds; i++) {
            Runner.runRound(cars);
            OutputManager.printRoundResult(cars);
        }
        
        // 우승자 출력
        OutputManager.printWinner(cars);

        // 자원 해제
        Console.close();
    }
}
