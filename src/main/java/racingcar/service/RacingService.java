package racingcar.service;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.NumberEnum;

public class RacingService {
    public boolean moveOrStop(){
        int random = Randoms.pickNumberInRange(NumberEnum.MIN_RANGE.getNumber(), NumberEnum.MAX_RANGE.getNumber());
        return random >= NumberEnum.REQUIREMENT_MOVE.getNumber();
    }
}
