package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Referee;

public class RefereeService {

    private final Referee referee;

    public RefereeService(Referee referee) {
        this.referee = referee;
    }

    public List<Car> inputCarNames(String inputCarNames) {
        List<String> carNames = referee.inputCarNames(inputCarNames);

        return createCarList(carNames);
    }

    private List<Car> createCarList (List<String> carNamesList) {
        List<Car> entryList = new ArrayList<>();
        carNamesList.forEach((carName) -> entryList.add(new Car(carName)));

        return entryList;
    }

    public int saveRoundNumber(String inputRoundNumber) {
        return referee.inputRoundNumber(inputRoundNumber);
    }

}
