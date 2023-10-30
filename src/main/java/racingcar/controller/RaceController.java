package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.NumberGenerator;
import racingcar.domain.Referee;
import racingcar.util.InputValidator;
import racingcar.view.OutputView;

public class RaceController {
    public static final String DELIMITER = ",";
    private final OutputView outputView;

    public RaceController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNames = askCarNames();
        List<Car> cars = createCars(carNames);

        System.out.println("시도할 회수는 몇회인가요?");
        int moveCount = askMoveCount();

        System.out.println("\n실행 결과");
        repeatMoveCars(moveCount, cars);

        Referee referee = new Referee(cars);
        List<Car> winners = referee.findWinners();

        outputView.showWinners(winners);
    }

    public void tryMoveCars(List<Car> cars) {
        for (Car car : cars) {
            int randomNumber = NumberGenerator.generateRandomNumber();

            car.moveForward(randomNumber);
            String moveTryResult = car.expressMoveDistance();

            outputView.showMoveDistance(moveTryResult);
        }
    }

    public void repeatMoveCars(int moveCount, List<Car> cars) {
        while (moveCount-- > 0) {
            tryMoveCars(cars);
            System.out.println();
        }
    }

    public List<String> askCarNames() {
        String inputNames = Console.readLine();
        return divideCarNames(inputNames);
    }

    public int askMoveCount() {
        String inputMoveCount = Console.readLine();
        int moveCount = Integer.valueOf(inputMoveCount);

        return moveCount;
    }

    public List<String> divideCarNames(String inputNames) {
        List<String> carNames = Arrays.asList(inputNames.split(DELIMITER));
        InputValidator.validateCarNamesSize(carNames);
        InputValidator.validateCarNameLength(carNames);

        return carNames;
    }

    public List<Car> createCars(List<String> carNames) {
        return carNames.stream()
                .map(carName -> new Car(carName.trim()))
                .collect(Collectors.toList());
    }
}
