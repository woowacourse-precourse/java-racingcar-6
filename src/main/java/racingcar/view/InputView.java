package racingcar.view;

import static racingcar.view.RacingCarConsole.*;
import static racingcar.view.RacingCarConstants.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.RacingCar;

public class InputView {
    public List<String> readRacingCars() {
        print(CAR_NAME_PROMPT);
        String[] carNames = Console.readLine().split(CAR_NAME_DELIMITER);

        List<String> racingCars = Arrays.stream(carNames)
                .map(String::trim)
                .collect(Collectors.toList());
        return racingCars;
    }

    public int readAttemptsNumber() {
        print(ATTEMPTS_PROMPT);
        return Integer.parseInt(Console.readLine());
    }
}
