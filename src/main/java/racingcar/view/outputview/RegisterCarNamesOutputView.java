package racingcar.view.outputview;

import java.util.Map;

public class RegisterCarNamesOutputView implements OutputView {
    private static final String INPUT_RACING_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";

    @Override
    public void print(Map<String, Object> model) {
        System.out.println(INPUT_RACING_CAR_NAMES);
    }
}
