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
        if(Randoms.pickNumberInRange(Num.ZERO.value,Num.NINE.value) >= Num.FOUR.value){
            return 1;
        };
        return 0;
    }
    enum Num {
        ZERO(0),
        FOUR(4),
        NINE(9);

        private final int value;

        Num(int value) {
            this.value = value;
        }
    }
}
