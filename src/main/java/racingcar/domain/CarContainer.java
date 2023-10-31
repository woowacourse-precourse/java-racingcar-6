package racingcar.domain;

import racingcar.dto.CarPositionDto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CarContainer {
    private static final String NAME_DELIMITER = ",";
    public static final int MIN = 0;
    private static final int GO = 4;
    private final List<RacingCar> racingCars;
    private final NumberPicker numberPicker;
    public CarContainer(String carNames, NumberPicker numberPicker) {
        racingCars = Arrays.stream(carNames.split(NAME_DELIMITER))
                .map(RacingCar::new)
                .collect(Collectors.toList());

        this.numberPicker = numberPicker;
    }

    public void moveRacingCars() {
        for (RacingCar racingCar : racingCars) {
            move(racingCar);
        }
    }

    private void move(RacingCar racingCar) {
        int number = numberPicker.pickNumber();
        if (number >= GO){
            racingCar.move();
        }
    }

    public List<CarPositionDto> toDto() {
        return racingCars.stream()
                .map(RacingCar::toDto)
                .collect(Collectors.toList());
    }

    public List<String> findWinner() {
        int max = findMaxPosition();
        return racingCars.stream()
                .filter(racingCar -> racingCar.matchPosition(max))
                .map(RacingCar::getCarName)
                .collect(Collectors.toList());
    }

    private int findMaxPosition() {
        int max = MIN;
        for (RacingCar car : racingCars) {
            max = Math.max(car.getPosition(), max);
        }
        return max;
    }
}
