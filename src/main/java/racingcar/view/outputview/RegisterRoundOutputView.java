package racingcar.view.outputview;

import java.util.Map;

public class RegisterRoundOutputView implements OutputView {
    private static final String INPUT_TOTAL_ROUND = "시도할 회수는 몇회인가요?";

    @Override
    public void print(Map<String, Object> model) {
        System.out.println(INPUT_TOTAL_ROUND);
    }
}
