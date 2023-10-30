package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Racing;
import racingcar.domain.car.Car;
import racingcar.dto.CarDto;
import racingcar.dto.RaceConditionDto;

public class CarRacingImp implements CarRacing{
    private Racing racing;
    private int numberOfRace;

    @Override
    public void addCar(String[] carNames){
        List<Car> cars = convertToCarList(carNames);
        initializeRace(cars);
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

    @Override
    public List<CarDto> getWinner() {
        return racing.getCarWithLongestDistance();
    }

    private static List<Car> convertToCarList(String[] carNames) {
        return Arrays.stream(carNames)
                .map(Car::new)
                .toList();
    }

    private void initializeRace(List<Car> cars){
        this.racing = new Racing(cars);
    }

    private List<CarDto> racingProgress() {
        racing.start();
        return racing.getAllCarDistances();
    }

}
