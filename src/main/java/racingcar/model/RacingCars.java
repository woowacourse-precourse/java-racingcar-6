package racingcar.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.enums.Symbol;

public class RacingCars {
    private final List<RacingCar> racingCars;

    private RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars from(String inputCarNames) {
        String[] carNames = inputCarNames.split(Symbol.CAR_NAME_DELIMITER.getValue());
        return new RacingCars(
                Arrays.stream(carNames)
                        .map(RacingCar::new)
                        .toList()
        );
    }

    public static RacingCars from(List<RacingCar> racingCars) {
        return new RacingCars(
                racingCars
        );
    }

    public List<RacingCar> getRacingCars() {
        return racingCars;
    }

    public String toNames() {
        StringBuilder stringBuilder = new StringBuilder();
        IntStream.range(0, racingCars.size())
                .forEach(i -> {
                    stringBuilder.append(racingCars.get(i).getName());
                    if (i < racingCars.size() - 1) {
                        stringBuilder.append(Symbol.WINNER_DELIMITER.getValue());
                    }
                });
        return stringBuilder.toString();
    }
}
