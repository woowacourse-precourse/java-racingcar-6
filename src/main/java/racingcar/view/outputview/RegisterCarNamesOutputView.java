package racingcar.view.outputview;

import java.util.Map;

public class RegisterCarNamesOutputView implements OutputView {

    @Override
    public void print(Map<String, Object> model) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
}
