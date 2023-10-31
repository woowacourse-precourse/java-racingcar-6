package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Validator;

public record Car(
    String name
) {
    public static Car of(String name) {
        Validator.validateCarName(name);
        return new Car(name);
    }

    public int move() {
        if(Randoms.pickNumberInRange(0,9) >= 4){
            return 1;
        };
        return 0;
    }
}
