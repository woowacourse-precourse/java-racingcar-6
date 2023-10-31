package racingcar.service.input;


import racingcar.dto.input.CarInputDto;
import racingcar.dto.input.TimeInputDto;

public interface Input {
    CarInputDto getCarInput();
    TimeInputDto getTimeInput();
}
