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
}
