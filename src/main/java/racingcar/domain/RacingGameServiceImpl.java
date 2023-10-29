package racingcar.domain;

import static racingcar.enums.Constant.BEGIN_NUMBER;
import static racingcar.enums.Constant.END_NUMBER;
import static racingcar.enums.Constant.FORWARD_THRESHOLD;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.controller.dto.WinnerDto;

public class RacingGameServiceImpl implements RacingGameService {

    @Override
    public void playRound(final Cars cars) {
        List<Car> carList = cars.getCar();
        for (Car car : carList) {
            if (canMoveForward(generateRandomNumber())) {
                car.moveForward();
            }
        }
    }

    @Override
    public WinnerDto findWinner(Cars cars) {
        cars.sortingCarsOrderByPosition();
        Car winnerCar = cars.get(0);

        List<String> winnerCarNames = cars.getCar().stream()
                .filter(car -> car.isSamePosition(winnerCar))
                .map(Car::getName)
                .collect(Collectors.toList());
        return new WinnerDto(winnerCarNames);
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(BEGIN_NUMBER.getConstant(), END_NUMBER.getConstant());
    }

    private boolean canMoveForward(final int number) {
        if (number >= FORWARD_THRESHOLD.getConstant()) {
            return true;
        }
        return false;
    }
}
