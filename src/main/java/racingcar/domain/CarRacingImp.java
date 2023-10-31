package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.car.Car;
import racingcar.dto.CarDto;
import racingcar.dto.RaceConditionDto;
import racingcar.exception.ErrorMessage;

public class CarRacingImp implements CarRacing {
    private Racing racing;
    private int numberOfRace;

    @Override
    public void addCar(String[] carNames){
        if(isInvalidCarNames(carNames)){
            throw new IllegalArgumentException(ErrorMessage.EMPTY_CAR_STRING_LIST);
        }
        List<Car> cars = convertToCarList(carNames);
        initializeRace(cars);
    }

    private static boolean isInvalidCarNames(String[] carNames) {
        return carNames == null || carNames.length == 0;
    }

    private void initializeRace(List<Car> cars){
        this.racing = new Racing(cars);
    }

    @Override
    public void addNumberOfRace(int nuber) {
        this.numberOfRace = nuber;
    }

    @Override
    public RaceConditionDto start() {
        List<List<CarDto>> raceCondition = new ArrayList<>();
        for (int i = 0; i < numberOfRace; i++) {
            raceCondition.add(racingProgress());
        }
        return new RaceConditionDto(raceCondition);
    }

    private List<CarDto> racingProgress() {
        racing.start();
        return racing.getAllCarDistances();
    }

    @Override
    public List<CarDto> getWinner() {
        return racing.getCarWithLongestDistance();
    }

    private static List<Car> convertToCarList(String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .toList();
    }

}
