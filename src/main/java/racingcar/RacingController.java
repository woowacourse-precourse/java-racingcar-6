package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Entity.Car;
import racingcar.constant.CarStatus;
import racingcar.util.Calculation;
import racingcar.util.ConsolePrint;
import racingcar.util.Exception;
import racingcar.util.Parsing;

import java.util.List;

public class RacingController {
    private ConsolePrint consolePrint = new ConsolePrint();
    private Calculation calculation = new Calculation();
    private RacingService racingService = new RacingService();
    private List<Car> cars; // 경주에 참여하는 자동차 정보 리스트
    private int tryCount;   // 경주 시도 횟수

    public void startGame() {
        consolePrint.requestCarNameInput();
        String carNameInput = Console.readLine();   // 자동차 이름 입력
        cars = racingService.carInputExceptionAndParsing(carNameInput);  // 에러 미발생 시 cars에 값 할당

        consolePrint.requestTryCountInput();
        String tryCountInput = Console.readLine();  // 시도 회수 입력
        tryCount = racingService.tryCountExceptionAndParsing(tryCountInput);    // 에러 미발생 시 tryCount에 값 할당

        consolePrint.informRacingResult();

        int count = 0;
        while (count++ < tryCount) {    // tryCount마다 실행 결과 계산 후 출력
            racingService.playRacing(cars);
        }

        List<Car> winners = calculation.judgeWhoIsWinner(cars); // 최종 우승자 계산
        consolePrint.finalWinner(winners);
    }
}
