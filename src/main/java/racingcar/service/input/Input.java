package racingcar.service.input;


import racingcar.dto.CarInputDto;
import racingcar.dto.TimeInputDto;

public interface Input {
    CarInputDto getCarInput();
    TimeInputDto getTimeInput();
}
