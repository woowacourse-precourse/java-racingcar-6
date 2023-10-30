package racingcar;

import java.util.ArrayList;
import java.util.List;

public class MockRandomNumberGenerator implements RandomNumberGenerator {
    private List<Integer> numberList = new ArrayList<>();
    private int index = 0;

    public MockRandomNumberGenerator(int... values) {
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
