package racingcar.input;

import static racingcar.input.RacingCarInputValidator.isInputPlayNumberValidated;
import static racingcar.input.RacingCarInputValidator.isInputRacingCarsValidated;
import static racingcar.printer.RacingCarPrinter.askHowManyNumberToPlay;
import static racingcar.printer.RacingCarPrinter.askRacingCars;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import org.assertj.core.util.VisibleForTesting;
import racingcar.service.RacingCar;

public class RacingCarInputReader {
    static final String RACING_CAR_INPUT_SPLITTER = ",";
    public static Map<String, RacingCar> getRacingCarMapFromConsole() {
        askRacingCars();
        String input = Console.readLine();
        if (!isInputRacingCarsValidated(input)) {
            throw new IllegalArgumentException("자동차 이름을 다시 입력해주세요.");
        }
        return makeRacingCarMap(input);
    }

    @VisibleForTesting
    protected static Map<String, RacingCar> makeRacingCarMap(String input) {
        return Arrays.stream(input.split(RACING_CAR_INPUT_SPLITTER))
                .map(name -> new RacingCar(name, 0))
                .collect(Collectors.toMap(
                        RacingCar::name,
                        racingCar -> racingCar));
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
