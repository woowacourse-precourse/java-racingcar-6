package racingcar.input;

import static racingcar.input.RacingCarInputValidator.isInputPlayNumberValidated;
import static racingcar.input.RacingCarInputValidator.isInputRacingCarsValidated;
import static racingcar.printer.RacingCarPrinter.askHowManyNumberToPlay;
import static racingcar.printer.RacingCarPrinter.askRacingCars;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.util.VisibleForTesting;
import racingcar.service.RacingCar;

public class RacingCarInputReader {
    static final String RACING_CAR_INPUT_SPLITTER = ",";
    public static List<RacingCar> getRacingCarsFromConsole() {
        askRacingCars();
        String input = Console.readLine();
        if (!isInputRacingCarsValidated(input)) {
            throw new IllegalArgumentException("자동차 이름을 다시 입력해주세요.");
        }
        return makeRacingCarList(input);
    }

    @VisibleForTesting
    protected static List<RacingCar> makeRacingCarList(String input) {
        return Arrays.stream(input.split(RACING_CAR_INPUT_SPLITTER))
                .map(RacingCar::new)
                .collect(Collectors.toList());
    }

    public static int getPlayNumberFromConsole() {
        askHowManyNumberToPlay();
        String input = Console.readLine();
        if (!isInputPlayNumberValidated(input)) {
            throw new IllegalArgumentException("시도할 회수를 다시 입력해주세요.");
        }
        return Integer.parseInt(input);
    }
}
