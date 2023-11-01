package racingcar.view;

import java.util.List;
import racingcar.constant.Notice;
import racingcar.model.Car;

public class Output {

    public static void printRunResultNotice() {
        System.out.println(Notice.RUN_RESULT);
    }

    public static void printRunResult(Car car) {
        System.out.println(car.getName() + " : " + car.getPositionStatus());
    }

    public static void printWinnerResult(List<String> winnerList) {
        String winnerNameStr = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + winnerNameStr);
    }

    public static void printBlankLine() {
        System.out.println();
    }

}
