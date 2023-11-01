package racingcar.service;

import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class GameService {
    private final List<Car> cars = new ArrayList<>();

    public GameService() {
    }

    public void start(String carNameInput, String tryCountInput) {
        setCars(carNameInput);
    }

    private void setCars(String carNameInput) {
        List<String> carNames = getCarNames(carNameInput);
        carNames.forEach(carName ->
            cars.add(new Car(carName))
        );
    }

    private List<String> getCarNames(String carNameInput) {
        //TODO: carNameInput 입력 형식 체크
        String[] split = carNameInput.split(",");
        return List.of(split);
    }


}
