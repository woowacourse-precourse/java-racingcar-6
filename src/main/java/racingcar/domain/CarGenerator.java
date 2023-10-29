package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import java.util.LinkedHashMap;


public class CarGenerator {



    public LinkedHashMap<String, String> createCarList(String stringCarList) {
        LinkedHashMap<String, String> carList = new LinkedHashMap<>();
        String[] cars = splitStringByCommas(stringCarList);
        for (String car : cars) {
            if (carList.containsKey(car)){
                throw new IllegalArgumentException("자동차 이름 중복입니다");
            }
            carList.put(car, "");
        }
        return carList;
    }

    public String[] splitStringByCommas(String stringCarList) {
        String[] carList = stringCarList.split(",");
        return carList;
    }

    public String inputCarList() {
        return Console.readLine();
    }
}
