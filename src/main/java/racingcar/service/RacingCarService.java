package racingcar.service;

import static racingcar.global.Constants.MAX_NUMBER_RANGE;
import static racingcar.global.Constants.MIN_NUMBER;
import static racingcar.global.Constants.MIN_NUMBER_RANGE;
import static racingcar.global.Validation.validateRound;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarGroup;

public class RacingCarService {

    public CarGroup createCarGroup(String carNames, String delimiter) {

        String[] separateCarName = carNames.split(delimiter);

        List<Car> carList = Arrays.stream(separateCarName)
            .map(Car::from)
            .collect(Collectors.toList());

        return CarGroup.from(carList);
    }

    public int getRoundNumber(String round) {
        validateRound(round);
        return Integer.parseInt(round);
    }

    public void moveCarGroup(CarGroup carGroup) {
        carGroup.getCars()
            .stream()
            .filter(car -> Randoms.pickNumberInRange(MIN_NUMBER_RANGE, MAX_NUMBER_RANGE) >= MIN_NUMBER)
            .forEach(Car::move);
    }

    public List<String> getWinners(CarGroup carGroup) {
         return carGroup.getCars().stream()
            .filter(car -> car.getPosition() == carGroup.getMaxPosition())
            .map(Car::getName)
            .collect(Collectors.toList());
    }

}
