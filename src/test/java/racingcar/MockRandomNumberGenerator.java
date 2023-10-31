package racingcar;

import java.util.ArrayList;
import java.util.List;

public class MockRandomNumberGenerator implements RandomNumberGenerator {
    private static final MockRandomNumberGenerator INSTANCE = new MockRandomNumberGenerator();
    private List<Integer> numberList;
    private int index = 0;

    private MockRandomNumberGenerator() {
    }

    public static MockRandomNumberGenerator getInstance() {
        return INSTANCE;
    }

    public void init(int... values) {
        numberList = new ArrayList<>();

        for (int value : values) {
            numberList.add(value);
        }
    }

    @Override
    public int generateRandomNumber() {
        int generatedNumber = numberList.get(index);
        changeIndex();
        return generatedNumber;
    }

    private void changeIndex() {
        index = (index + 1) % numberList.size();
    }
}
