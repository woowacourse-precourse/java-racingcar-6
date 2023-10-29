package racingcar.service.output;

import racingcar.domain.Cars;
import racingcar.dto.output.CarsOutputDto;

public interface Output {
    void showPlaying(CarsOutputDto carsOutputDto);
    void showResult(CarsOutputDto carsOutputDto);

}
