package racingcar.converter;

import racingcar.domain.Car;
import racingcar.domain.dto.RunningCarDto;

public class DtoConverter {

    public static RunningCarDto toRunningCarRecord(Car car) {
        return new RunningCarDto(car.getName(), car.getLocation());
    }
}
