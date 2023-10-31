package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class GameUtil {

    public static Map<String, Integer> Savecars(String inputCarsName) {

        // 입력받은 자동차 이름을 분할하여 저장
        String[] cars = inputCarsName.split(",");
        Map<String, Integer> carsList = new LinkedHashMap<>();

        //입력된 자동차들에 value값 0 저장
        for (String car : cars) {
            carsList.put(car, 0);
        }
        return carsList;
    }


}
