package racingcar;

import racingcar.domain.cars;
import racingcar.io.InputView;
import racingcar.io.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();

        outputView.print("경주 할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분합니다.)");
        cars cars = new cars(InputView.readCarNames());
    }
}
