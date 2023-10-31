package racingcar.domain.game;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;
import racingcar.domain.result.GameResult;
import racingcar.domain.result.GameResultGenerator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCarGameRunner {
    private final String GAME_START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String NUMBER_OF_ROUND_MESSAGE = "시도할 회수는 몇회인가요?";

    private Cars cars;

    public void run() {
        String carNameInput = getPlayerInput(GAME_START_MESSAGE);
        List<String> carNames = processCarNameInput(carNameInput);
        cars = Cars.createCars(getEntry(carNames));

        String numberOfRoundInput = getPlayerInput(NUMBER_OF_ROUND_MESSAGE);
        validateInput(numberOfRoundInput);
        int numberOfRound = Integer.parseInt(numberOfRoundInput);

        System.out.println("\n실행결과");

        for (int i = 0; i < numberOfRound; i++) {
            cars.moveForward();
            System.out.println();
        }

        GameResult result = GameResultGenerator.generateResult(cars);
        System.out.print(result.getResult());
    }

    private String getPlayerInput(String message) {
        System.out.println(message);
        return Console.readLine();
    }

    private List<String> processCarNameInput(String input) {
        List<String> tmpNameList = Arrays.stream(input.split(", *")).toList();
        return tmpNameList.stream()
                .filter(name -> !name.isBlank())
                .toList();
    }

    private List<Car> getEntry(List<String> carNames) {
        return carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    private void validateInput(String input) {
        String trimmed = input.trim();
        if (trimmed.startsWith("-")) {
            throw new IllegalArgumentException("시도 횟수는 음수일 수 없습니다.");
        }
        try {
            Integer.parseInt(trimmed);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 입력값입니다.");
        }
    }
}
