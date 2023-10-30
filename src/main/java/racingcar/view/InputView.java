package racingcar.view;

import static racingcar.exception.RacingCarExceptionType.*;
import static racingcar.view.RacingCarConsole.*;
import static racingcar.view.RacingCarConstants.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class InputView {
    public List<String> readRacingCars() {
        print(CAR_NAME_PROMPT);
        String[] carNames = Console.readLine().split(CAR_NAME_DELIMITER);

        List<String> racingCars = Arrays.stream(carNames)
                .map(String::trim)
                .collect(Collectors.toList());
        validateCarNames(racingCars);
        return racingCars;
    }

    public int readAttemptsNumber() {
        print(ATTEMPTS_PROMPT);
        return Integer.parseInt(Console.readLine());
    }

    public void validateCarNames(List<String> racingCars) {
        checkEmptyNames(racingCars);
        checkDuplicatedNames(racingCars);
        checkInvalidFormat(racingCars);
    }

    private void checkEmptyNames(List<String> racingCars) {
        if (racingCars.isEmpty()) {
            throw new IllegalArgumentException(EMPTY_NAME.getMessage());
        }
    }

    private void checkDuplicatedNames(List<String> racingCars) {
        Set<String> uniqueName = new HashSet<>(racingCars);
        if (uniqueName.size() != racingCars.size()) throw new IllegalArgumentException(DUPLICATE_NAME.getMessage());
    }

    private void checkInvalidFormat(List<String> racingCars) {
        for (String racingCar : racingCars) {
            Pattern pattern = Pattern.compile("(\\w)+");
            if (!pattern.matcher(racingCar).matches()) {
                throw new IllegalArgumentException(INVALID_CAR_NAME_FORMAT.getMessage());
            }
        }
    }


}
