package racingcar.service;

import static racingcar.global.Validation.validateRound;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.CarGroup;
import racingcar.domain.Winners;
import racingcar.dto.InputCarRequestDto;

public class RacingCarService {

    public CarGroup createCarGroup(InputCarRequestDto inputCarRequestDto) {
        String[] separateCarGroup = inputCarRequestDto.carName()
            .split(inputCarRequestDto.Delimiter());

        List<Car> carList = Arrays.stream(separateCarGroup).map(Car::new)
            .collect(Collectors.toList());
        return new CarGroup(carList);
    }

    public int getRoundNumber(String round) {
        validateRound(round);
        return Integer.parseInt(round);
    }

    public CarGroup moveCarGroup(CarGroup carGroup) {
        carGroup.move();
        return carGroup;
    }

    public Winners getWinners(CarGroup carGroup) {
        return new Winners(carGroup.getWinnerList());
    }
}
