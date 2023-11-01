package racingcar.mock;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.RandomNumberGenerator;

import java.util.ArrayList;
import java.util.List;

public class MockRandomNumberGenerator implements RandomNumberGenerator {
    private static final MockRandomNumberGenerator instance = new MockRandomNumberGenerator();

    private final int MIN_RANDOM_NUMBER = 0;
    private final int MAX_RANDOM_NUMBER = 9;

    private List<Integer> numberList = new ArrayList<>();
    private int index = 0;

    private MockRandomNumberGenerator() {
    }

    public static MockRandomNumberGenerator getInstance() {
        return instance;
    }

    public void init(int... values) {
        numberList = new ArrayList<>();

        for (int value : values) {
            numberList.add(value);
        }
    }

    @Override
    public int generateRandomNumber() {
        if(numberList.isEmpty()) {
            return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
        }
        int generatedNumber = numberList.get(index);
        changeIndex();
        return generatedNumber;
    }

    private void changeIndex() {
        index = (index + 1) % numberList.size();
    }
}
