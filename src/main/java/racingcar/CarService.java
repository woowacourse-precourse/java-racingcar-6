package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.Number.*;

public class CarService {

    public Car create(String name){
        checkName(name);
        return new Car(name);
    }
    private void checkName(String name){
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5글자 이하여야 합니다.");
        }
    }
    public void move(Car car){
        Integer power = makeRandomPower();
        car.move(power);
    }
    private Integer makeRandomPower(){
        return Randoms.pickNumberInRange(NUMBER_RANGE_START, NUMBER_RANGE_END);
    }
}
