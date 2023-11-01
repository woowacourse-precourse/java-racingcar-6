package racingcar.domain;

import racingcar.constant.Constant;

import java.util.List;

public class Referee {
    public static void compare(int BASE_NUMBER) {
        List<Integer> computerRandomNumber = NumberGenerator.createRandomNumber();
        for(int i = 0; i < computerRandomNumber.size(); i++) {
            if(computerRandomNumber.get(i) > BASE_NUMBER) {
                Judgment.moveForward(i);
            }
        }
    }
}
