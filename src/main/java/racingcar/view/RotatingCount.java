package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.RotatingCountValidator;

public class RotatingCount {
    private RotatingCountValidator rotatingCountValidator = new RotatingCountValidator();
    private Order order = new Order();
    public int input() {
        order.rotateCount();
        String racingCount = Console.readLine();

        if(rotatingCountValidator.check(racingCount)){
            order.gameProcess();
            return  stringToInteger(racingCount);
        }
        throw new IllegalArgumentException("잘못된 Rotating count 입니다.");

    }

    private int stringToInteger(String racingCount){
        return Integer.parseInt(racingCount);
    }
}
