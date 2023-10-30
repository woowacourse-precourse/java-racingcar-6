package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.validation.Validation;
import racingcar.view.InputView;
import racingcar.view.OutPutView;

import java.util.*;
import java.util.stream.Collectors;

public class GameService {
    private final int MIN_NUM = 0;
    private final int MAX_NUM = 9;
    private final int POSSIBLE_MOVE_NUM = 4;
    private final InputView inputView = new InputView();
    private final OutPutView outPutView = new OutPutView();
    private final Validation validation = new Validation();
    private final List<Car> cars = new ArrayList<>();
    private StringBuilder sb;

    public int randomNum() {
        return Randoms.pickNumberInRange(MIN_NUM, MAX_NUM);
    }

    public void carMove() {
        for (Car car : cars) {
            if (randomNum() >= POSSIBLE_MOVE_NUM) {
                car.setMove(car.getMove() + 1);
            }
        }
    }

    public void enterCar() {
        String name = inputView.inputCar();
        for (String n : validation.nameCheck(name)) {
            cars.add(new Car(n));
        }
    }

    public int enterChance() {
        String chance = inputView.inputChance();
        validation.chanceCheck(chance);
        return Integer.parseInt(chance);
    }

    public StringBuilder printStick(int k) {
        sb = new StringBuilder();
        sb.append("-".repeat(Math.max(0, cars.get(k).getMove())));
        return sb;
    }

    public void gameResult(int chance) {
        outPutView.outputResult();
        for (int i = 0; i < chance; i++) {
            carMove();
            for (int k = 0; k < cars.size(); k++) {
                System.out.println(cars.get(k).getName() + " : " + printStick(k));
            }
            System.out.println();
        }
    }

    public void winnerList() {
        List<Car> winners = cars.stream().collect(Collectors.groupingBy(Car::getMove, Collectors.toList()))
                .entrySet()
                .stream()
                .max(Comparator.comparing(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .orElse(Collections.emptyList())
                .stream()
                .toList();

        String printWinners = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        outPutView.outputWinner(printWinners);
    }
}
