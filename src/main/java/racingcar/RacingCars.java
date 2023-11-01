package racingcar;

import static racingcar.ErrorMessage.CAR_NAME_DUPLICATED;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

public class RacingCars {

    private List<RacingCar> racingCars = new ArrayList<>();

    public RacingCars(List<RacingCar> racingCars) {
        this.racingCars = racingCars;
    }

    public static RacingCars from(String[] carNames) {
        validateCarNameDuplicate(carNames);
        return new RacingCars(Arrays.stream(carNames).map(RacingCar::new).toList());
    }

    private static void validateCarNameDuplicate(String[] carNames) {
        if(Arrays.stream(carNames).distinct().count()!= carNames.length){
            throw new IllegalArgumentException(CAR_NAME_DUPLICATED);
        }
    }

    public void race() {
        racingCars.stream().forEach(RacingCar::moveOrStay);
    }

    private Integer findMaxLocation() {
        return racingCars.stream().mapToInt(RacingCar::getLocation).max().getAsInt();
    }

    public List<String> getWinnerNames() {
        Integer maxLocation = findMaxLocation();
        return racingCars.stream()
                .filter(racingCar -> racingCar.getLocation() == maxLocation)
                .map(RacingCar::getName)
                .toList();
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(System.lineSeparator());
        racingCars.stream().forEach(racingCar -> stringJoiner.add(racingCar.toString()));
        return stringJoiner.toString();
    }
}
