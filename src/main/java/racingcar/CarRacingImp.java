package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Racing;
import racingcar.domain.car.Car;
import racingcar.dto.CarDto;

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
    public List<CarDto> progress() {
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

    private void initializeRace(List<Car> cars){
        this.racing = new Racing(cars);
    }

}
