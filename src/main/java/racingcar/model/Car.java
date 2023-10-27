package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import racingcar.utils.Validator;

public class Car {
    private final List<String> names;
    private final int attempt;
    private List<Integer> mileage;

    public Car(List<String> names, int attempt) {
        this.names = names;
        this.attempt = attempt;
        this.mileage = new ArrayList<>(Collections.nCopies(names.size(), 0));
    }

    public void forward () {
        for(int i = 0 ; i < names.size(); i++) {
            int number = Randoms.pickNumberInRange(0,9);
            if(number >= 4) {
                mileage.set(i, mileage.get(i) + 1);
            }
        }
    }

    public int getAttempt() {
        return attempt;
    }

    public List<Integer> getMileage() {
        return mileage;
    }
}
