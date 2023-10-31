package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.dto.WinnerDto;

import java.util.List;

public class OutputView {
    private static final String PROCESS_RESULT = "실행 결과";
    private static final String PARTITION_FORMAT = " : ";
    private static final String PROCESS_POSITION = "-";
    private static final String FINAL_WINNER = "최종 우승자 : ";

    public static void printGameStartMessage() {
        System.out.println(PROCESS_RESULT);
    }

    public static void currentRacingPosition(Cars cars) {
        List<Car> participants = cars.getCars();
        for (Car car : participants) {
            String position = currentPosition(car);
            System.out.println(car.getName() + PARTITION_FORMAT + position);
        }
        System.out.println();
    }

    private static String currentPosition(Car car) {
        StringBuilder sb = new StringBuilder();
        int position = car.getPosition();
        for (int i = 0; i < position; i++) {
            sb.append(PROCESS_POSITION);
        }
        return sb.toString();
    }

    public static void result(WinnerDto winners) {
        System.out.print(FINAL_WINNER);
        String winner = String.join(", ", winners.getNames());

        System.out.println(winner);
    }
}
