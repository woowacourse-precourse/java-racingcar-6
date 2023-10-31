package racingcar.domain;

import java.util.LinkedHashMap;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class CarController {

    List<String> cars;

    public CarController(List<String> cars) {

        this.cars = cars;
    }

    public LinkedHashMap<String, Integer> racingResult = new LinkedHashMap<>();

    public LinkedHashMap<String, Integer> gameStart() {

        for (String car : cars) {
            racingResult.put(car, racingResult.getOrDefault(car, 0) + isForward());
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
