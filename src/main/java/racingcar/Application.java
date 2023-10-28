package racingcar;

import racingcar.domain.Random;

public class Application {
    public static void main(String[] args) {
        Random random = new Random();

        int result = random.makeRandomNum();
        System.out.println(result);
    }
}
