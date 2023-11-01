package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGameView {

    private static final String NAME_INPUT_GUIDE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String ROUND_INPUT_GUIDE = "시도할 회수는 몇회인가요?";
    private static final String RESULT_MESSAGE = "실행 결과";
    public static final String FORMAT_PRINT_ROUND = "%s : %s\n";
    public static final String FORMAT_PRINT_WINNERS = "최종 우승자 : %s";

    public List<String> inputCarNames() {
        System.out.println(NAME_INPUT_GUIDE);
        String carNames = Console.readLine();
        InputValidator.validateCarNames(carNames);
        return Arrays.asList(carNames.split(","));
    }

    public int inputGameRounds() {
        System.out.println(ROUND_INPUT_GUIDE);
        String rounds = Console.readLine();
        InputValidator.validatePositiveNumber(rounds);
        System.out.println();
        return Integer.parseInt(rounds);
    }

    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE);
    }

    public void printRoundResult(List<RacingCar> cars) {

        for (RacingCar car : cars) {
            System.out.printf(FORMAT_PRINT_ROUND, car.getName(), car.getMovement());
        }
        System.out.println();
    }

    public void printWinners(List<RacingCar> cars) {
        String winners = cars.stream()
                .map(RacingCar::getName)
                .collect(Collectors.joining(", "));
        System.out.printf(FORMAT_PRINT_WINNERS, winners);
    }
}
