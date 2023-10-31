package racingcar.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import racingcar.common.consts.SystemConst;
import racingcar.common.utils.NameParser;

public class RacingCars {
    private final List<Car> racingCars = new ArrayList<>();
    private final NumberGenerator numberGenerator;

    public RacingCars(NumberGenerator numberGenerator) {
        this.numberGenerator = numberGenerator;
    }

    public RacingCarsResult getRacingCarsResult() {
        sort();
        return findWinners();
    }

    public void generateCar(String name) {
        CarDto carDto = new CarDto(name, SystemConst.INITIAL_ADVANCE);
        Car car = new Car(carDto);
        racingCars.add(car);
    }

    public void generateCars(String inputCarValue) {
        String[] names = NameParser.parseName(inputCarValue);
        for (String name : names) {
            generateCar(name);
        }
    }

    private RacingCarsResult findWinners() {
        RacingCarsResult result = new RacingCarsResult();
        Car highestCar = racingCars.get(0);
        result.add(highestCar);
        int index = 1;
        while (index < racingCars.size() && highestCar.compareTo(racingCars.get(index)) == 0) {
            result.add(racingCars.get(index));
            index++;
        }
        return result;
    }

    public int size() {
        return racingCars.size();
    }

    public void add(Car car) {
        racingCars.add(car);
    }

    public RacingCars moveRacingCars() {
        for (Car car : racingCars) {
            moveRacingCar(car);
        }
        return this;
    }

    private void moveRacingCar(Car car) {
        if (isMove()) {
            car.move();
        }
    }

    private boolean isMove() {
        int number = numberGenerator.makeRandomNumber();
        return number >= SystemConst.MOVE_FORWARD_NUMBER;
    }

    public void sort() {
        Collections.sort(racingCars);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Car car : this.racingCars) {
            sb.append(car.toString());
            sb.append(SystemConst.LINE_SEPARATOR);
        }
        return sb.toString();
    }
}
