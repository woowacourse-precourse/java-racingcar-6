package racingcar;

import java.util.Random;

public class RandomNumber {
    public static int RandomNumber(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("잘못된 범위의 무작위 값 생성");
        }
        return new Random().nextInt(max - min + 1) + min;
    }
}

