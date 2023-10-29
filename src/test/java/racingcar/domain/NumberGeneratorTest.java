package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberGeneratorTest {
    @Test
    void randomNumber() {
        for (int i = 0; i < 10; i++){
        NumberGenerator numberGenerator = new NumberGenerator();
        int num = numberGenerator.createRandomNumber();
        System.out.print(num);
        }
        System.out.println();
    }
}