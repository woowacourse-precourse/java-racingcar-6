package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private List<String> forwardList = new ArrayList<>();
    private final String FORWARD = "-";
    private final int ZERO = 0;
    private final int LAST_RANGE = 9;
    private final int VALID_FORWARD_NUMBER = 4;
    private int moving;

    public void createForwardList(int size) {
        for (int i = ZERO; i < size; i++) {
            forwardList.add("");
        }
    }

    public List<String> play(int tryCount, int size, Cars cars, View view) {
        for (int i = ZERO; i < tryCount; i++) {
            for (int j = ZERO; j < size; j++) {
                int random = Randoms.pickNumberInRange(ZERO, LAST_RANGE);
                validRandom(random);
                view.printCarName(cars.getCar(j).getCarName());
                validForward(j);
                view.printForward(forwardList.get(j));
                moving = ZERO;
            }
            view.printBlank();
        }
        return forwardList;
    }

    private void validRandom(int random) {
        if (random >= VALID_FORWARD_NUMBER) {
            moving++;
        }
    }

    private void validForward(int index) {
        if (moving != ZERO) {
            forwardList.set(index, forwardList.get(index) + FORWARD);
        }
    }
}
