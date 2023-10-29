package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class CarController {

// 진행과정
// 자동차 리스트를 가지고 와서
// 레이싱 1세트 진행 시키고
// 차1대의 전진이 끝날때마다 해시맵에 기록
// 1세트가 끝나면 해시맵 반환

    List<String> cars;

    public CarController(List<String> cars) {

        this.cars = cars;
    }

    public HashMap<String, Integer> racingResult = new HashMap<>();

    public HashMap<String, Integer> gameStart() {
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
