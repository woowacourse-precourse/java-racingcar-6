package racingcar.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.enums.GameConstant;

public class Cars {
    private List<Car> carList;

    public Cars(List<String> carNameList) {
        carList = new ArrayList<>();

        for(String carName : carNameList) {
            Car car = new Car(carName);

            carList.add(car);
        }
    }

    @Override
    public String toString() {
        String delimiter = GameConstant.DELIMITER.getContent();
        List<String> carNames = carList
                .parallelStream()
                .map(Car::toString)
                .collect(Collectors.toList());

        return String.join(delimiter, carNames);
    }
}
