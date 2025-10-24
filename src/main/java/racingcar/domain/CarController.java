package racingcar.domain;

import java.util.AbstractMap;
import java.util.LinkedHashMap;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;

public class CarController {

    List<String> cars;

    public CarController(List<String> cars) {

        this.cars = cars;
    }
    //중복된 이름이 불가능하다는 요구조건이 없으므로 중복 허용을 위해 키로 Map.Entry<Integer, String> 사용 (인덱스, 자동차이름)쌍
    public LinkedHashMap<Map.Entry<Integer, String>, Integer> racingResult = new LinkedHashMap<>();

    public LinkedHashMap<Map.Entry<Integer, String>, Integer> gameStart() {

        for (int carIndex = 0; carIndex < cars.size() ; carIndex++) {
            Map.Entry<Integer, String> carEntry = new AbstractMap.SimpleEntry<>(carIndex, cars.get(carIndex));
            racingResult.put(carEntry, racingResult.getOrDefault(carEntry, 0) + isForward());
        }
        return racingResult;
    }

    public int isForward() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        return isBiggerThanFour(randomNumber);
    }


    public int isBiggerThanFour(int number) {
        if (number >= 4) {
            return 1;
        }
        return 0;
    }


}
