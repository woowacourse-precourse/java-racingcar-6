package racingcar;

import static racingcar.constant.AllConstants.*;
import static racingcar.constant.ExceptionMessage.*;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import racingcar.view.InputView;

public class Application {
    public static void main(String[] args) {
        // 자동차 이름 입력
        InputView inputView = new InputView();
        Map<String, Integer> carList = inputView.inputCarName();
        int rounds = inputView.inputRounds();
        // 자동차 경주 진행 단계
        System.out.println("\n실행 결과");
        for (int i = 0; i < rounds; i++) {
            for (String carName : carList.keySet()) {
                // 현재 자동차의 전진/정지 여부 결정
                int randomNum = Randoms.pickNumberInRange(RANDOM_MIN, RANDOM_MAX);
                int moves = carList.get(carName);
                if (randomNum >= RANDOM_FOUR) {
                    moves += MOVE_FORWARD;
                    carList.put(carName, moves);
                }
                // 해당 차수의 실행 결과 출력
                System.out.print(carName + " : ");
                for (int j = 0; j < moves; j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        // 자동차 경주 종료 단계
        // 가장 많이 전진한 자동차 명단 추리기
        Integer maxValue = Collections.max(carList.values());
        List<String> winnerList = new ArrayList<>();
        for (String carName : carList.keySet()) {
            if (maxValue.equals(carList.get(carName))) {
                winnerList.add(carName);
            }
        }
        // 최종 우승자 출력
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerList.size(); i++) {
            if (i == 0) {
                System.out.print(winnerList.get(i));
            }
            else if (i > 0) {
                System.out.print(", " + winnerList.get(i));
            }
        }
    }
}
