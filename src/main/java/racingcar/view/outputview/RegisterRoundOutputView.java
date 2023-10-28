package racingcar.view.outputview;

import java.util.Map;

public class RegisterRoundOutputView implements OutputView {
    @Override
    public void print(Map<String, Object> model) {
        System.out.println("시도할 회수는 몇회인가요?");
    }
}
