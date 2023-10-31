package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.data.Car;
import racingcar.util.CarUtil;

public class CarService {
    private List<Car> carList = new ArrayList<>();
    private int round;

    public void start() {
        carList = getCarList();
        round = getRound();

        CarUtil.printResult();
        while (round-- > 0) {
            carList.forEach(res -> {
                res.move(isPossibleMove());
            });
            CarUtil.printNewLine();
        }

        int max = -1;
        List<String> winnerList = new ArrayList<>();
        for (Car car : carList) {
            if (max < car.getMoveDistance()) {
                max = car.getMoveDistance();
                winnerList.clear();
                winnerList.add(car.getName());
            } else if (max == car.getMoveDistance()) {
                winnerList.add(car.getName());
            }
        }

        StringBuilder winnerNames = new StringBuilder(winnerList.get(0));
        for (int i = 1; i < winnerList.size(); i++) {
            winnerNames.append(CarUtil.WINNER_SEPARATOR).append(winnerList.get(i));
        }

        CarUtil.printVictory(winnerNames.toString());
    }

    private List<Car> getCarList() {
        CarUtil.printGetCarList();
        String[] inputs = Console.readLine().split(CarUtil.CAR_NAME_SPLIT);

        List<Car> carList = new ArrayList<>();
        for (String input : inputs) {
            if (input.length() > CarUtil.MAX_CAR_NAME_LENGTH) {
                throw new IllegalArgumentException();
            }

            carList.add(new Car(input, CarUtil.FIRST_SCORE));
        }

        return carList;
    }

    private int getRound() {
        CarUtil.printGetRound();
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isPossibleMove() {
        return Randoms.pickNumberInRange(CarUtil.MIN_RANDOM_NUMBER, CarUtil.MAX_RANDOM_NUMBER)
                >= CarUtil.MIN_POSSIBLE_MOVE_NUMBER;
    }
}
