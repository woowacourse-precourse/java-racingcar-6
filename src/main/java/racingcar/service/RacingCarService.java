package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.InputUtil;
import racingcar.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class RacingCarService {
    private final InputUtil inputUtil;
    private final RandomUtil randomUtil;
    private Cars cars;

    public RacingCarService() {
        inputUtil = new InputUtil();
        randomUtil = new RandomUtil();
    }

    public void start() {
        initCars();
        int count = inputUtil.getCount();
        for (int i = 0; i < count; i++) {
            move(cars);
        }
    }

    public void move(Cars cars) {
        cars.moveCars();
        cars.printMoves();
    }

    public void initCars() {
        List<String> input = inputUtil.getCarNames();
        cars = createCars(input);
    }

    public Cars createCars(List<String> names) {
        List<Car> carList = new ArrayList<>();
        names.forEach(name -> carList.add(new Car(name)));
        cars = new Cars(carList);
        return cars;
    }
}
