package racingcar.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import racingcar.model.RacingCar;

public final class RacingGameConsole {
    private static final String RACING_CAR_REGEX = ",";

    private RacingGameConsole() {
    }

    public static List<RacingCar> readRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String userInput = Console.readLine();
        String[] carNames = userInput.split(RACING_CAR_REGEX);

        return Arrays.stream(carNames)
                .map(RacingCar::new)
                .toList();
    }

    public static int readEndLap() {
        System.out.println("시도할 회수는 몇회인가요?");

        String userInput = Console.readLine();

        try {
            return Integer.parseInt(userInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자여야 합니다.");
        }
    }
}
