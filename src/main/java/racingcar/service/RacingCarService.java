package racingcar.service;

import static racingcar.global.Validation.validateRound;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.domain.Winners;
import racingcar.dto.InputCarDto;

public class RacingCarService {

    public CarGroup createCarGroup(InputCarDto inputCarDto) {
        String carNames = inputCarDto.carName();
        String delimiter = inputCarDto.Delimiter();

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
        carGroup.move();
    }

    public Winners getWinners(CarGroup carGroup) {
        return Winners.from(carGroup.getWinnerList());
    }
}
