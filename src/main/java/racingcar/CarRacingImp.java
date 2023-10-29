package racingcar;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.Racing;
import racingcar.domain.car.Car;
import racingcar.dto.CarDto;

public class CarRacingImp implements CarRacing{
    private Racing racing;

    @Override
    public void addCar(String[] carNames){
        List<Car> cars = convertToCarList(carNames);
        initializeRace(cars);
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
