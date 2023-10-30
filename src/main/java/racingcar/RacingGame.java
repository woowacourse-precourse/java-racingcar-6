package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.domain.Car;
import racingcar.domain.CarList;

public class RacingGame {
    private CarList carList;



    public String printNameAndPosition(List<Car> cars, List<Integer> carsPosition){
        return IntStream.range(0, cars.size())
                .mapToObj(index -> cars.get(index).getName() + " : " + "-".repeat(carsPosition.get(index)))
                .collect(Collectors.joining("\n"));
    }


    public List<Car> generateCar(String carNames) {
        List<Car> cars = Arrays.stream(carNames.split(","))
                .map(Car::new)
                .toList();
        carList = new CarList(cars);
        return cars;
    }
}
