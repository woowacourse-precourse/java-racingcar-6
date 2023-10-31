package racingcar.common.factory;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.common.type.Names;
import racingcar.common.type.TrialCount;
import racingcar.domain.Car;
import racingcar.dto.input.InputDTO;
import racingcar.dto.output.AllRoundDTO;
import racingcar.dto.output.RoundDTO;
import racingcar.dto.output.WinnerDTO;

public class DTOFactory {

    private DTOFactory() {
        throw new AssertionError();
    }

    // AllRoundDTO를 생성하는 public 메서드
    public static AllRoundDTO createAllRoundDTO(List<Car> cars) {
        return new AllRoundDTO(carsToRoundDTOs(cars));
    }

    public static WinnerDTO createWinnerDTO(List<String> winnerNames) {
        return new WinnerDTO(winnerNames);
    }

    public static List<RoundDTO> carsToRoundDTOs(List<Car> cars) {
        return cars.stream()
                .map(DTOFactory::carToRoundDTO)
                .collect(Collectors.toList());
    }

    public static InputDTO createInputDTO(TrialCount trialCount, Names names) {
        return new InputDTO(trialCount, names);
    }

    // RoundDTO를 생성하는 private 메서드
    private static RoundDTO carToRoundDTO(Car car) {
        return new RoundDTO(car.getName(), car.getDistance());
    }
}
