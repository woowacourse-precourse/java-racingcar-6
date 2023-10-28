package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class Circuit {
    private List<Car> cars;

    public Circuit(List<Car> cars) {
        this.cars = cars;
    }

    public void run() {
        cars = cars.stream().map((car) -> car.runAndReturnNewCar(createRandomNumber())).toList();
    }


    private Long createRandomNumber() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        return (long) randomNum;
    }

    public String getWinner() {
        Long maxPosition = cars.stream().mapToLong(Car::getPosition).max().orElseThrow(NoSuchElementException::new);

        return cars.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }

    public void printCarsTrace() {
        cars.forEach(car -> System.out.println(car.getCarStatus()));
    }
}
