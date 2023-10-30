package racingcar.view;

import java.util.List;
import racingcar.util.Constants;

public class OutputView {
    public static void printCarResult(List<String> result) {
        result.forEach(System.out::println);
    }

    public static void printResultConstant() {
        System.out.println(Constants.RESULT_CONSTANT.getConstant());
    }

}
