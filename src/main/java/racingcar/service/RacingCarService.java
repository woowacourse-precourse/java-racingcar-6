package racingcar.service;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.util.InputUtil;

import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.StringConstant.*;

public class RacingCarService {
    private final InputUtil inputUtil;
    private Cars cars;

    public RacingCarService() {
        inputUtil = new InputUtil();
    }

    public void move() {
        cars.moveCars();
        cars.printMoves();
    }

    public void initCars() {
        System.out.print(INPUT_CAR_NAMES_MESSAGE.getMessage());
        List<String> input = inputUtil.getCarNames();
        cars = createCars(input);
    }

    public int initRound() {
        System.out.print(INPUT_ROUND_NUMBER_MESSAGE.getMessage());
        return inputUtil.getRound();
    }

    public void printWinner() {
        String winner = cars.getWinner();
        System.out.print(OUTPUT_WINNER_MESSAGE.getMessage());
        System.out.print(winner);
    }

    public Cars createCars(List<String> names) {
        List<Car> carList = new ArrayList<>();
        names.forEach(name -> carList.add(new Car(name)));
        return new Cars(carList);
    }
}
