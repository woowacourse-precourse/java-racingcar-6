package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.RacingCountValidator;

public class RotatingCount {
    RacingCountValidator racingCountValidator = new RacingCountValidator();
    Order order = new Order();
    public int input() {
        order.rotateCount();
        String racingCount = Console.readLine();

        if(racingCountValidator.check(racingCount)){
            order.gameProcess();
            return  stringToInteger(racingCount);
        }
        throw new IllegalArgumentException("잘못된 입력 입니다.");

    }

    private int stringToInteger(String racingCount){
        return Integer.parseInt(racingCount);
    }
}
