package racingcar.view;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import racingcar.dto.Car;

public class OutputView {
    private static final String GAME_FINAL_WINNER = "최종 우승자 : ";
    private static final String INPUT_MESSAGE_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_MESSAGE_TOTAL_ROUND = "시도할 회수는 몇회인가요?";
    public static final String OUTPUT_MESSAGE_RESULT = "실행 결과";

    public static void printBlankLine(int blankLineNumber) {
        System.out.print("\n".repeat(Math.max(0, blankLineNumber)));
    }
    public static void printInputMessageCarInfo() {
        System.out.println(INPUT_MESSAGE_CAR_NAMES);
    }

    public static void printInputMessageTotalRound() {
        System.out.println(INPUT_MESSAGE_TOTAL_ROUND);
    }

    public static void printOutputMessageResult() {
        System.out.println(OUTPUT_MESSAGE_RESULT);
    }

    public static void printStatusOfRaceCar(Car car) {
        System.out.println(car.name() + " : " + "-".repeat(car.position()));
    }

    public static void printGameWinner(List<Car> winnerCar) {
        String result = winnerCar.stream()
                .map(Car::name)
                .collect(Collectors.joining(", "));
        System.out.println(GAME_FINAL_WINNER + result);
    }
}
