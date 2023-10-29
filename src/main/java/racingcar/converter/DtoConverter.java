package racingcar.converter;

import racingcar.domain.Car;
import racingcar.domain.dto.RunningCarDto;
import racingcar.domain.dto.WinnerDto;

public class DtoConverter {

    public static RunningCarDto toRunningCarDto(Car car) {
        return new RunningCarDto(car.getName(), car.getLocation());
    }

    public static WinnerDto toWinnerDto(Car car) {
        return new WinnerDto(car.getName());
    }
}
