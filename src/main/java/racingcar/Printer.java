package racingcar;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Printer {
    public static final String REQUEST_NAME = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public static final String EMPTY_STRING_ERROR = "String is empty";
    public static final String RANGE_ERROR = "String index out of range: 5";
    public static final String REQUEST_ROUND = "시도할 회수는 몇회인가요?";
    public static final String NOT_AN_INTEGER_ERROR = "Input is not an integer";
    public static final String PRINT_PROGRESS = "\n실행 결과";
    public static final String PRINT_WINNER = "최종 우승자 : ";

    public static void printWinner(List<Integer> progress, List<String> cars) {
        int maxMove = Collections.max(progress);
        List<String> winner = IntStream.range(0, cars.size())
                .filter(i -> progress.get(i) == maxMove)
                .mapToObj(cars::get)
                .toList();

        System.out.print(PRINT_WINNER);
        if (winner.size() == 1) {
            System.out.println(winner.get(0));
        } else {
            System.out.println(String.join(", ", winner));
        }
    }

    public static void printResultOfEachRound(List<String> cars, List<Integer> progress) {
        for (int j = 0; j < cars.size(); j++) {
            int carAt = progress.get(j);
            System.out.printf("%s : %s\n", cars.get(j), "-".repeat(carAt));
        }
        System.out.println();
    }
}
