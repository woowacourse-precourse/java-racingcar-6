package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.Validator;
public class InputView {
    Validator validator = new Validator();
    public String inputCarNames(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        return validator.checkCarValidate(carNames);
    }

    public int inputCount(){
        System.out.println("시도할 회수는 몇회인가요?");
        String input = Console.readLine();
        return validator.checkRaceValidate(input);
    }
}
