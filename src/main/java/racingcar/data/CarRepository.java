package racingcar.data;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.utils.CarUtil;
import racingcar.validator.CarInputValidator;

public class CarRepository {
    private final List<Car> carList = new ArrayList<>();

    public CarRepository() {
    }

    public void setCarList(String[] carNames) {
        for (String carName : carNames) {
            CarInputValidator.validateCar(carName);
            carList.add(new Car(carName, CarUtil.FIRST_SCORE));
        }
    }

    public void playRound() {
        carList.forEach(car -> {
            car.move(isPossibleMove());
        });
    }

    public String findWinners() {
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
