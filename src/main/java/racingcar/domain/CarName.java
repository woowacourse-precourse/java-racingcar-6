package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CarName {
    public static List<String> inputCarName() {
        String CarNames = Console.readLine();
        return Arrays.asList(CarNames.split(","));
    }

    public final Map<String, Integer> getcarList() {
        List<String> carList = inputCarName();
        Map<String, Integer> carMap = new HashMap<>();
        carList.forEach((car)->{
            carMap.put(car, 0);
        });
        return carMap;
    }
}