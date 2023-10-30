package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String RESULT_PHRASE = "실행 결과";
    private static final String DISTINCTION = " : ";
    private static final String ONE_BLOCK = "-";

    public static void printResultPhrase() {
        System.out.println();
        System.out.println(RESULT_PHRASE);
    }

    public static void printRacingGameStatus(List<Car> cars) {
        for (Car car : cars) {
            StringBuilder sb = new StringBuilder();
            sb.append(car.getName() + DISTINCTION);

            int position = car.getPosition();
            while (position-- > 0) {
                sb.append(ONE_BLOCK);
            }

            System.out.println(sb);
        }
        System.out.println();
    }
}
