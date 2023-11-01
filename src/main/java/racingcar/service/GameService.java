package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Cars;
import racingcar.domain.Game;
import racingcar.domain.dto.CarDto;

public class GameService {
    public List<CarDto> convertCarsToCarDtoList(Cars cars) {
        return cars.getCars().stream()
                .map(car -> CarDto.createNewCarDto(car.getName(), car.getDistance()))
                .collect(Collectors.toUnmodifiableList());
    }

    public List<CarDto> getRoundResult(Cars cars, Game game) {
        cars.updateAllDistance();
        game.incrementExecutedRoundCount();
        return convertCarsToCarDtoList(cars);
    }

}
