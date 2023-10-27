package racingcar;

import racingcar.model.Car;
import racingcar.type.MessageType;

import java.util.List;

import static racingcar.type.MessageType.*;

/**
 * @Class : 자동차 경주 서비스
 */
public class RacingService {

    /**
     * @Method : 자동차 경주
     */
    public void racing() {

        println(ASK_CAR_NAME);
        List<Car> cars = getAttendCars();

        println(ASK_ATTEMPTS);
        int attempts = getAttemptsCount();
        println(LINE_BREAK);
        println(RESULT);

        int currentAttempts = 0;

        while (currentAttempts < attempts) {
            printRacingResult(cars);
            println(LINE_BREAK);
            currentAttempts++;
        }

        printWinner();
    }


    /**
     * @Method : 참가 자동차 가져오기
     */
    private List<Car> getAttendCars() {
        return null;
    }


    /**
     * @Method : 시도 회수 가져오기
     */
    private int getAttemptsCount() {
        return 0;
    }


    /**
     * @Method : 경주 결과 출력
     */
    private void printRacingResult(List<Car> cars) {
    }


    /**
     * @Method : 우승자 출력
     */
    private void printWinner() {
    }


    /**
     * @Method : 줄 바꿈 포함 출력
     */
    private static void println(MessageType messageType) {
        System.out.println(messageType.getMessage());
    }

}
