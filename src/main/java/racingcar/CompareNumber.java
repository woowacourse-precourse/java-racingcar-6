package racingcar;

import java.util.ArrayList;
import java.util.Collections;

public class CompareNumber {
    private ArrayList<Integer> numbers;
    private ArrayList<Integer> maxNumbers;

    public CompareNumber(ArrayList<Integer> numbers) {
        this.numbers = numbers;
        this.maxNumbers = new ArrayList<>();
    }

    public void compare() {
        // 가장 큰 수를 찾습니다.
        int maxNumber = Collections.max(numbers);

        // 가장 큰 수가 2개 이상일 수 있으므로,
        // ArrayList에 저장합니다.
        for (int number : numbers) {
            if (number == maxNumber) {
                maxNumbers.add(number);
            }
        }
    }

    public ArrayList<Integer> getMaxNumbers() {
        return maxNumbers;
    }
}
