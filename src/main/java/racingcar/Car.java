package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

    public List<String> movedCount;
    public List<String> names;

    public Car(List<String> names) {
        this.names = names;
        validateCarNames(this.names);
        trimCarNames(this.names);
        initializeMovedCount();
    }

    private void initializeMovedCount() {
        movedCount = new ArrayList<>(Collections.nCopies(this.names.size(), ""));
    }

    private void validateCarNames(List<String> carNames) {
        Validator.checkCarCount(carNames);
        Validator.checkBlankAndLength(carNames);
        Validator.checkDuplication(carNames);
    }

    private void trimCarNames(List<String> carNames) {
        for (int i = 0; i < carNames.size(); i++) {
            carNames.set(i, carNames.get(i).trim());  // 수정 필요
        }
    }

    public void move(int roundCount) {
        System.out.println("실행 결과");

        for (int i = 0; i < roundCount; i++) {

            for (int j = 0; j < movedCount.size(); j++) {

                if (Randoms.pickNumberInRange(0, 9) >= 4) {
                    movedCount.set(j, movedCount.get(j) + "-");
                }
            }

            for (int k = 0; k < this.names.size(); k++) {
                System.out.println(this.names.get(k) + " : " + movedCount.get(k));
            }

            System.out.println();
        }
    }

}
