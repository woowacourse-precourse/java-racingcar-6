package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Domain.CarGroup;

public class GameModel {
    public CarGroup playGameRound(CarGroup carGroup) {
        return null;
    }

    public Boolean determineMove(){
        int number = Randoms.pickNumberInRange(0, 9);
        return number >= 4;
    }
}
