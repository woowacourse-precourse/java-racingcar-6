package racingcar.domain;

import static racingcar.domain.enums.Constants.RANDOM_END_RANGE;
import static racingcar.domain.enums.Constants.RANDOM_START_RANGE;
import static racingcar.domain.enums.Error.DUPLICATE_NAME;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.util.ErrorException;

public class Cars {
    private List<Car> carList;

    public Cars(List<Car> carList) {
        validateDuplicateCar(carList);
        this.carList = carList;
    }

    private void validateDuplicateCar(List<Car> carList) {
        long distinctCarCount = carList.stream()
                .distinct()
                .count();

        if (distinctCarCount != carList.size()) {
            throw new ErrorException(DUPLICATE_NAME);
        }
    }

    public List<Car> getCarList() {
        return this.carList;
    }

    public void moveCars() {
        carList.stream().forEach(x -> x.move(generateRandomNumber()));
    }

    private int generateRandomNumber() {
        return Randoms.pickNumberInRange(RANDOM_START_RANGE, RANDOM_END_RANGE);
    }

    private int getMaxPosition() {
        return carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(IllegalArgumentException::new);
    }

    public List<String> getWinner() {
        int maxPosition = getMaxPosition();
        return carList.stream()
                .filter(x -> x.getPosition() == maxPosition)
                .map(x -> new String(x.getName()))
                .toList();
    }
}
