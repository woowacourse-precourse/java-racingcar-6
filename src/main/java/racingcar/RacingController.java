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
    private Exception exception = new Exception();
    private ConsolePrint consolePrint = new ConsolePrint();
    private Parsing parsing = new Parsing();
    private Calculation calculation = new Calculation();
    private List<Car> cars; // 경주에 참여하는 자동차 정보 리스트
    private int tryCount;   // 경주 시도 횟수
    public void startGame() {
        consolePrint.requestCarNameInput();
        String carNameInput = Console.readLine();   // 자동차 이름 입력
        carInputExceptionAndParsing(carNameInput);  // 에러 미발생 시 cars에 값 할당

        consolePrint.requestTryCountInput();
        String tryCountInput = Console.readLine();  // 시도 회수 입력
        trtCountExceptionAndParsing(tryCountInput);    // 에러 미발생 시 tryCount에 값 할당

        consolePrint.informRacingResult();

        int count = 0;
        while(count++ <= tryCount) {    // tryCount마다 실행 결과 계산 후 출력
            playRacing();
        }

        List<Car> winners = calculation.judgeWhoIsWinner(cars); // 최종 우승자 계산
        consolePrint.finalWinner(winners);
    }

    private void playRacing() {
        for (Car car : cars) {
            int randomNumber = calculation.generateRandomNumberInRange();

            CarStatus carStatus = calculation.judgeCarMoveOrStop(randomNumber); // 랜덤 숫자별 전진 & 중지 상태 반환
            car.setMoveCount(carStatus);
            car.setNowMoveTrace(carStatus);
        }

        consolePrint.racingTryResult(cars);
    }

    private void carInputExceptionAndParsing(String carNameInput) {
        exception.isNameNull(carNameInput);
        cars = parsing.StringToCarList(carNameInput);
        for (Car car : cars) {
            exception.isNameNull(car.getName());
            exception.isNameInRange(car.getName());
        }
    }

    private void trtCountExceptionAndParsing(String tryCountInput) {
        exception.isInteger(tryCountInput);
        tryCount = parsing.stringToInt(tryCountInput);
        exception.isGreaterThanZero(tryCount);
    }
}
