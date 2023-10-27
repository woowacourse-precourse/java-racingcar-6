package racingcar;


import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class RacingController {
    RacingService racingService = new RacingService();

    void launch() {
        // 1. 자동차 이름 입력 → 검증 → 저장(생성)
        inputCarName();

        // 2. 자동차 이동 회수(경주 차수) 값 입력, 검증, 저장
        int validCount = inputCarCount();

        // 3. 차수별 경주 실행 및 이동 결과 출력
        printCarTotalMove(validCount);

        // 4. todo 우승자 출력

    }

    void inputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        List<String> validNameList = racingService.testValidNames(names);
        racingService.generateCar(validNameList);
    }

    int inputCarCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        String count = Console.readLine();
        return racingService.testValidCount(count);
    }

    void printCarTotalMove(int validCount){
        System.out.println("\n실행 결과");
        for (int phase = 0; phase < validCount; phase++){
            racingService.generateMove();
            System.out.println(racingService.getCarTotalMove());
        }
    }
}