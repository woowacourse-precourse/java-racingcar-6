package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RacingcarService {

    public void game(List<Car> carList){
        for (Car car : carList) {
            Advance advance = getAdvance();

            if(advance.isAdvance) {
                car.updateResult(advance.advanceCount);
            }
        }
    }

    public Advance getAdvance(){
        int advanceCount = Randoms.pickNumberInRange(0,9);

        if (advanceCount < 4){
            return new Advance(false, advanceCount);
        }

        return new Advance(true, advanceCount);
    }

}
