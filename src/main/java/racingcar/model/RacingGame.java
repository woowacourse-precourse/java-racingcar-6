package racingcar.model;

import static java.util.Objects.isNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RacingGame {

    private static final String REGEX_FOR_SEPARATE = ",";
    private final List<Car> racingCarList;

    private RacingGame(final String inputNameString) {
        validateInputNameString(inputNameString);
        String[] carNames = splitInputNameString(inputNameString);

        racingCarList = new ArrayList<>();
        Arrays.stream(carNames)
                .forEach(name -> racingCarList.add(new Car(name)));
    }

    public static RacingGame of(final String inputNameString) {
        return new RacingGame(inputNameString);
    }

    public List<Car> getRacingCarList() {
        return racingCarList;
    }

    private void validateInputNameString(String inputNameString) {
        if(isNull(inputNameString)) throw new IllegalArgumentException();
        if(inputNameString.isBlank()) throw new IllegalArgumentException();
    }

    private String[] splitInputNameString(String inputNameString) {
        return inputNameString.split(REGEX_FOR_SEPARATE);
    }
}
