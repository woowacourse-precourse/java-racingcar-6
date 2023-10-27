package racingcar.util;

import racingcar.model.Car;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TransferUtil {
    private final static int CAR_START_POSITION = 0;
    public List<String> transferStringToListString(String targetString){
        if (targetString.isEmpty()){
            return new ArrayList<>(Collections.emptyList());
        }
        String[] targetStringList = targetString.split(",");
        return new ArrayList<>(Arrays.asList(targetStringList));
    }

    public List<Car> transferStringToListCar(String carNames){
        List<String> carNameList = transferStringToListString(carNames);
        return carNameList.stream().map(carName -> new Car(carName,CAR_START_POSITION))
                .collect(Collectors.toList());
    }
}
