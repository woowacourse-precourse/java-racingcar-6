package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.util.RacingCountValidator;

public class RotatingCount {
    RacingCountValidator racingCountValidator = new RacingCountValidator();
    public int input() {
        String racingCount = Console.readLine();
        if(racingCountValidator.check(racingCount)){
            return  stoi(racingCount);
        }
        throw new IllegalArgumentException("잘못된 입력 입니다.");
    }

    private int stoi(String racingCount){
        return Integer.parseInt(racingCount);
    }
}
