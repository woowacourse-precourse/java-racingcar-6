package racingcar.domain;

import racingcar.constant.Constant;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class Referee {
    public static void compare(int BASE_NUMBER) {
        int sizeOfComputerRandomNumber = InputView.getNumberOfCars();
        List<Integer> computerRandomNumber = NumberGenerator.createRandomNumber();
        for(int i = 0; i < sizeOfComputerRandomNumber; i++) {
            if(computerRandomNumber.get(i) >= BASE_NUMBER) {
                Judgment.moveForward(i);
            }
        }
    }
}
