package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.RacingCar;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    private static final int RACINGCARS_MAX_COUNT = 5;

    public static List<RacingCar> inputRacingCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = Console.readLine()
                .replaceAll(" ", "")
                .split(",");
        validationCarsCount(carNames);

        List<RacingCar> cars = Arrays.stream(carNames)
                .map(name -> RacingCar.of(name, 0))
                .collect(Collectors.toList());
        return cars;
    }

    private static void validationCarsCount(String[] carNames) {
        if(carNames.length > RACINGCARS_MAX_COUNT) {
            throw new IllegalArgumentException("자동차의 개수는 최대 5개 입니다.");
        }
    }

    public static int inputRaceCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String inputCount = Console.readLine();
        validationNull(inputCount);
        validationNumber(inputCount);
        validationCount(inputCount);
        return Integer.parseInt(inputCount);
    }

    private static void validationNull(String input) {
        if (Objects.isNull(input) || input.length() == 0) {
            throw new IllegalArgumentException("입력된 내용이 없습니다.");
        }
    }

    private static void validationNumber(String input) {
        if (!Pattern.matches("^[0-9]*$", input)) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    private static void validationCount(String input) {
        if(Integer.parseInt(input) < 1) {
            throw new IllegalArgumentException("1이상 입력해야 합니다.");
        }
    }
}
