package racingcar;

import racingcar.domain.GenerateRandomNum;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GenerateRandomNum randomNum = new GenerateRandomNum();
        System.out.println(randomNum.createRandomNum());

    }
}
