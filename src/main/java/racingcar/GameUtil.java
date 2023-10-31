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

    public static Map<String, Integer> makeRandumNumber(Map<String, Integer> carsList, String[] cars) {

        // 랜덤 숫자를 뽑아서 값을 조정하고 Map에 저장
        for (String car : cars) {
            int randomNumber = Randoms.pickNumberInRange(0, 9); // 0부터 9까지의 랜덤 숫자
            int currentValue = carsList.get(car);

            if (randomNumber >= 4) {
                carsList.put(car, currentValue + 1); // 랜덤 숫자가 4 이상일 경우 +1을 해서 저장
            }
        }
        return carsList;
    }

}
