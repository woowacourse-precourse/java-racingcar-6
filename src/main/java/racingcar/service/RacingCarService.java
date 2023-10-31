package racingcar.service;

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

    private void validateRound(String round) {
        if (round == null || !round.matches("[0-9]+")) {
            throw new IllegalArgumentException("0이상의 숫자만 입력 가능합니다.");
        }
    }

    public CarGroup moveCarGroup(CarGroup carGroup) {
        carGroup.move();
        return carGroup;
    }

    public Winners getWinners(CarGroup carGroup) {
        return new Winners(carGroup.calculateWinners());
    }
}
