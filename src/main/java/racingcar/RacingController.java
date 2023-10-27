package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingController {
    RacingService racingService = new RacingService();

    void launch() {
        // 1. 자동차 이름 입력 → 검증 → 저장(생성)
        String names = inputName();
        List<String> validNameList = racingService.namesTest(names);
        racingService.generateCar(validNameList);

        // 2. 자동차 이동 회수(경주 차수) 값 입력, 검증, 저장
        String count = inputCount();
        if (racingService.isValidCount(count)) {
            // 3. todo 차수별 경주 실행 및 결과 출력
            // 4. todo 우승자 출력
        }
    }

    /**
     * 1-1. 자동차 이름 입력
     *
     * @return 사용자 자동차 이름 입력값
     */
    String inputName() {
        System.out.println("경주할 자동차 이름을 입력하세요.");
        return Console.readLine();
    }

    /**
     * 2-1. 시도 회수 입력
     *
     * @return 사용자 시도 회수 입력값
     */
    String inputCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}