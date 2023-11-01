package racingcar.View;

import java.util.ArrayList;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Cars;

public class OutputView {
    public static final String WINNER_GUIDE_MESSAGE = "최종 우승자 : ";
    public static final String GAME_RESULT_MESSAGE = "실행 결과";

    public static void printGameResultMessage(){
        System.out.println(GAME_RESULT_MESSAGE);
    }

    public static void printCarsResult(Cars cars) {
        for (Car car : cars.getCarList()) {
            String name = car.getName();
            int position = car.genPosition();
            printCarResult(name, position);
        }
    }

    public static void printCarResult(String name, int position) {
        StringBuilder sb = new StringBuilder(name + " : ");
        for (int i = 0; i < position; i++) {
            sb.append("-");
        }
        System.out.println(sb.toString());
    }

    public static void printWinners(ArrayList<String> winners) {
        System.out.print(WINNER_GUIDE_MESSAGE + winners.stream()
                .collect(Collectors.joining((", "))));
    }
}
