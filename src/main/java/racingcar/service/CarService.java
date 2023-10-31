package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.data.Car;
import racingcar.util.CarUtil;
import racingcar.validator.CarInputValidator;
import racingcar.validator.RoundInputValidator;

public class CarService {
    private List<Car> carList = new ArrayList<>();
    private int round;

    public void start() {
        carList = getCarList();
        round = getRound();

        playRound();
        String winnerNames = getWinnerNames();
        CarUtil.printWinner(winnerNames);
    }

    private List<Car> getCarList() {
        CarUtil.printGetCarList();
        String[] carNames = Console.readLine().split(CarUtil.CAR_NAME_SPLIT);
        CarInputValidator.checkCarNameDuplicate(carNames);

        List<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            CarInputValidator.checkCarNameLength(carName);
            carList.add(new Car(carName, CarUtil.FIRST_SCORE));
        }

        return carList;
    }

    private int getRound() {
        CarUtil.printGetRound();
        String round = Console.readLine();
        RoundInputValidator.checkRoundNumberFormat(round);

        return Integer.parseInt(round);
    }

    private void playRound() {
        CarUtil.printResult();
        while (round-- > 0) {
            carList.forEach(car -> {
                car.move(isPossibleMove());
            });
            CarUtil.printNewLine();
        }
    }

    private String getWinnerNames() {
        List<String> winnerList = getWinnerList();
        StringBuilder winnerNames = new StringBuilder(winnerList.get(0));
        for (int i = 1; i < winnerList.size(); i++) {
            winnerNames.append(CarUtil.WINNER_SEPARATOR).append(winnerList.get(i));
        }

        return winnerNames.toString();
    }

    private List<String> getWinnerList() {
        int maxDistance = carList.get(0).getMoveDistance();
        List<String> winnerList = new ArrayList<>(List.of(carList.get(0).getName()));

        int carListSize = carList.size();
        for (int i = 1; i < carListSize; i++) {
            Car car = carList.get(i);

            if (maxDistance < car.getMoveDistance()) {
                winnerList.clear();
                maxDistance = car.getMoveDistance();
                winnerList.add(car.getName());
            } else if (maxDistance == car.getMoveDistance()) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }

    private boolean isPossibleMove() {
        return Randoms.pickNumberInRange(CarUtil.MIN_RANDOM_NUMBER, CarUtil.MAX_RANDOM_NUMBER)
                >= CarUtil.MIN_POSSIBLE_MOVE_NUMBER;
    }
}
