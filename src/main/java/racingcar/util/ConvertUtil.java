package racingcar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.domain.Car;

public class ConvertUtil {

    public static List<Car> convertStrToListCar(String carNames) {
        List<Car> carList = new ArrayList<>();
        List<String> carNameList = Arrays.stream(carNames.split(",")).toList();
        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public static String convertListCarToStr(List<Car> cars) {
        List<String> carNames = cars.stream().map(Car::getName).toList();
        return String.join(", ", carNames);
    }

    public static String convertPositionToStr(int position) {
        String strPosition = "";
        for (int i = 0; i < position; i++) {
            strPosition += "-";
        }
        return strPosition;
    }

}
