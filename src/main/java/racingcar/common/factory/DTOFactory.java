package racingcar.common.factory;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.dto.output.RoundDTO;
import racingcar.dto.output.WinnerDTO;

public class DTOFactory {
    public static List<RoundDTO> carsToRoundDTOs(List<Car> cars) {
        return cars.stream()
                .map(DTOFactory::carToRoundDTO)
                .collect(Collectors.toList());
    }

    public static WinnerDTO createWinnerDTO(List<String> winnerNames) {
        return new WinnerDTO(winnerNames);
    }

    private static RoundDTO carToRoundDTO(Car car) {
        return new RoundDTO(car.getName(), car.getDistance());
    }
}
