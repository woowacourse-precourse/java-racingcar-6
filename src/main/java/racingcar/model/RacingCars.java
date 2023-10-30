package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.ValidateInput;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RacingCars {

    private final List<Car> racingCars;

    public RacingCars(String[] names) {
        ValidateInput.isRightCarNames(names);
        this.racingCars = createCars(names);
    }

    private List<Car> createCars(String[] carNames) {
        return Arrays.stream(carNames).map(name -> new Car(name)).collect(Collectors.toList());
    }


    public void move() {
        for (Car car : racingCars) {
            car.move(createRandomNumber());
        }
    }

    private int createRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }


    public List<String> getCarNames() {
        return racingCars.stream().map(car -> car.getName()).collect(Collectors.toList());
    }

    public List<Integer> getCarLocations() {
        return racingCars.stream().map(car -> car.getLocation()).collect(Collectors.toList());
    }


    public List<String> getWinners() {
        int locationMaxValue = getLocationMaxValue();

        return racingCars.stream()
                .filter(car -> car.getLocation() == locationMaxValue)
                .map(car -> car.getName()).collect(Collectors.toList());
    }

    private Integer getLocationMaxValue() {
        return Collections.max(getCarLocations());
    }
}
