package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingCarAssemblyService {

    public Cars assemble(List<String> inputCarNames) {
        List<Car> carList = inputCarNames.stream()
                .map(carName -> new Car(carName, new RandomCarEngine()))
                .collect(Collectors.toList());
        return new Cars(carList);
    }
}
