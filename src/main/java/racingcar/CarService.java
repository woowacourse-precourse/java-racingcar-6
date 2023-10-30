package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.Number.*;

public class CarService {

    public void move(Car car){
        Integer power = makeRandomPower();
        car.move(power);
    }
    private Integer makeRandomPower(){
        return Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
    }
}
