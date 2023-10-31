package racingcar.util.converter;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.dto.CarRegistrationDTO;

public class CarRegistrationConverter {

    public static List<CarRegistrationDTO> convertToDTOs(String carNames) {
        List<String> splitCarNames = CarNameSplitter.splitCarNames(carNames);
        return splitCarNames.stream()
                .map(CarRegistrationDTO::new)
                .collect(Collectors.toList());
    }
}
