package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingController {
    RacingService racingService = new RacingService();

    void launch() {
        // 1. 자동차값 입력 → 검증 → 저장
        String names = inputName();

        // 2. 시도 횟수 입력 기능
        // 3. 실행 결과 출력 기능
        // 4. 최종 우승자 출력 기능
    }

    // 1-1. 자동차 이름 입력 기능
    String inputName(){
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return Console.readLine();
    }
}
