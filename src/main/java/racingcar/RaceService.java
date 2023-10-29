package racingcar;

import java.util.List;
import racingcar.domain.car.Car;
import racingcar.domain.car.CarDto;
import racingcar.domain.car.CarDtoMapper;
import racingcar.domain.car.CarDtoValidator;
import racingcar.domain.round.RoundDto;
import racingcar.domain.round.RoundDtoMapper;
import racingcar.domain.round.RoundDtoValidator;

public class RaceService {
    private RaceService() {
    }

    private static RaceService instance;

    public static RaceService getInstance() {
        if (instance == null) {
            instance = new RaceService();
        }
        return instance;
    }

    public List<Car> getCarsFromInput(String raceCarNames) {
        CarDto carDto = new CarDto(raceCarNames);
        CarDtoValidator.validateCarDto(carDto);
        return CarDtoMapper.mapToCar(carDto);
    }

    public int getRoundFromInput(String roundInput) {
        RoundDto roundDto = new RoundDto(roundInput);
        RoundDtoValidator.validateRoundDto(roundDto);
        return RoundDtoMapper.mapToRound(roundDto);
    }
}
