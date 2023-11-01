package racingcar;

import racingcar.common.util.InputUtil;
import racingcar.common.util.OutputUtil;
import racingcar.common.util.Validator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputUtil inputUtil = new InputUtil(new Validator());
        OutputUtil outputUtil = new OutputUtil();
        Refree refree = new Refree();
        Circuit circuit = new Circuit(inputUtil, outputUtil, refree);
        circuit.start();
    }
}
