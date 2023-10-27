package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class ConvertUtil {

    public static List<Car> convertStrToListCar(String carNames){
        List<Car> carList = new ArrayList<>();
        List<String> carNameList = Arrays.stream(carNames.split(",")).toList();
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
        return carList;
    }

}
