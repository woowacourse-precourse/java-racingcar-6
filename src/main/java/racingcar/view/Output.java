package racingcar.view;

import java.util.List;
import racingcar.model.Car;

enum Messages {
    START_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    ATTEMPT_NUMBER_MESSAGE("시도할 회수는 몇회인가요?"),
    RESULT_MESSAGE("\n실행 결과"),
    FINAL_WINNER("최종 우승자 : ");

    private final String message;

    Messages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}


public class Output {
    public static void printStartMessage() {
        System.out.println(Messages
                .START_MESSAGE
                .getMessage());
    }

    public static void printAttemptNumberMessage() {
        System.out.println(Messages
                .ATTEMPT_NUMBER_MESSAGE
                .getMessage());
    }

    public static void printResultMessage() {
        System.out.println(Messages
                .RESULT_MESSAGE
                .getMessage());
    }

    public static void printRacingProgress() {
        List<String> carNames = Car.getNames();

        for (int i=0;i<carNames.size();i++){
            printPlayerScore(carNames, i);
        }

        System.out.println();
    }

    public static void printPlayerScore(List<String> carNames, int index) {
        System.out.print(carNames.get(index) + " : ");
        printDistance(index);
    }

    public static void printDistance(int index) {
        StringBuilder distance = new StringBuilder();
        List<Integer> carMoves = Car.getMoves();

        for (int i = 0; i < carMoves.get(index); i++) {
            distance.append("-");
        }

        System.out.println(distance);
    }

    public static void printWinners(String result) {
        System.out.println(Messages
                .FINAL_WINNER
                .getMessage() + result);
    }
}
