package racingcar;

import static racingcar.constants.BoundaryValue.MAX_RANDOM;
import static racingcar.constants.BoundaryValue.MIN_RANDOM;
import static racingcar.constants.BoundaryValue.MOVE_LIMIT;
import static racingcar.constants.Message.START_RACE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {

    public List<String> movedDistances;
    public List<String> names;

    public Car(List<String> names) {
        this.names = names;

        CarManager.validateNames(this.names);
        initializeDistances();
    }

    private void initializeDistances() {
        movedDistances = new ArrayList<>(Collections.nCopies(this.names.size(), ""));
    }

    public void move(int roundCount) {
        System.out.println(START_RACE.getMessage());

        for (int i = 0; i < roundCount; i++) {
            moveRandomly();
            printDistances();
        }

    }

    private void moveRandomly() {

        for (int j = 0; j < movedDistances.size(); j++) {

            if (Randoms.pickNumberInRange(MIN_RANDOM.get(), MAX_RANDOM.get()) >= MOVE_LIMIT.get()) {
                movedDistances.set(j, movedDistances.get(j) + "-");
            }

        }

    }

    private void printDistances() {

        for (int k = 0; k < names.size(); k++) {
            System.out.println(names.get(k) + " : " + movedDistances.get(k));
        }

        System.out.println();
    }
}
