package racingcar;

import java.util.ArrayList;

public class NumberGenerator {

    private ArrayList<Integer> numbers;
    
    public NumberGenerator(int carNameCount) {
        this.numbers = new ArrayList<>();
        do {
            int dValue = (int) (Math.random() * 10); // 0에서 9 사이의 난수 생성
            if (dValue > 4) {
                this.numbers.add(dValue);
            }
        } while (numbers.size() < carNameCount);
    }

    public ArrayList<Integer> getNumbers() {
        return this.numbers;
    }
}