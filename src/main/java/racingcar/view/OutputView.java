package racingcar.view;

import java.util.List;
import racingcar.dto.CarInfo;

public class OutputView {

    public static final String SEPARATOR = " : ";
    public static final String POSITION_BAR = "-";

    private OutputView() {
    }

    public static void printStart() {
        printNewLine();
        System.out.println("실행 결과");
    }

    public static void printCarStatus(CarInfo carInfo) {
        String name = carInfo.name();
        int position = carInfo.position();
        System.out.println(name + SEPARATOR + POSITION_BAR.repeat(position));
    }

    public static void printResult(List<String> names) {
        String result = String.join(", ", names);
        printNewLine();
        System.out.println("최종 우승자" + SEPARATOR + result);
    }

    public static void printNewLine() {
        System.out.println();
    }
}
