package racingcar.domain;

import java.util.HashMap;
import java.util.List;
import camp.nextstep.edu.missionutils.Randoms;

public class CarController {

//- [ ] 주어진 횟수(세트수) 동안 n대의 자동차는 전진 또는 멈출 수 있다. - carControler()
//    - [ ] n대의 자동차 - cars[]
//    - [ ] 전진 혹은 멈추는 조건 확인 - isForward
//      - [ ] 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. isForward()
//        - [ ] 0~9 사이의 무작위값 구현 - makeRandomNumbers()
//        - [ ] 4를 기준으로 전진 조건 확인  - isBiggerThanFour()
//    - [ ] 1세트 경주 결과 기록후 해시맵 반환 - gameStart
//      - [ ] 결과 기록 해시맵 - resultRacing HashMap<String, Integer>
//      - [ ] 경주 이후 결과 해시맵 에 기입. gameStart()

//    진행과정
// 자동차 리스트를 가지고 와서
// 레이싱 1세트 진행 시키고
// 차1대의 전진이 끝날때마다 해시맵에 기록
// 1세트가 끝나면 해시맵 반환

    List<String> cars;
    HashMap<String, Integer> racingResult = new HashMap<>();


    public CarController(List<String> cars) {
        this.cars = cars;
    }

    public HashMap<String, Integer> gameStart() {
        int moveResult = 0;
        for (String car : cars) {
            moveResult = isForward();
        }
        return null;
    }

    public int isForward() {
        int randomNumber = Randoms.pickNumberInRange(1, 9);
        boolean goOrStop = isBiggerThanFour(randomNumber);
        return 0;
    }


    public boolean isBiggerThanFour(int number) {
        return false;
    }


}
