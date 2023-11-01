package racingcar.view;

import java.util.List;
import racingcar.constant.Notice;
import racingcar.model.Car;

public class Output {

    public static void print(String str) {
        System.out.println(str);
    }

    public static void printRunResultNotice() {
        print(Notice.RUN_RESULT);
    }

    public static void printRunResult(Car car) {
        print(car.getName() + " : " + car.getPositionStatus());
    }

    public static void printWinnerResult(List<String> winnerList) {
        String winnerNameStr = String.join(", ", winnerList);
        print("최종 우승자 : " + winnerNameStr);
    }

    public static void printBlankLine() {
        System.out.println();
    }

}
