package racingcar.input.decorator;

import racingcar.input.UserInput;
import racingcar.vo.CarCollection;

public class CarCollectionPrintDecoratorUserInput extends DecoratorUserInput<CarCollection> {

    private static final String START_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    public CarCollectionPrintDecoratorUserInput(UserInput<CarCollection> userInput) {
        super(userInput);
    }

    @Override
    public CarCollection input() {
        System.out.println(START_MESSAGE);
        return userInput.input();
    }
}
