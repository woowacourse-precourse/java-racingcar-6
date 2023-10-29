package racingcar;

import racingcar.domain.NumberGenerator;
import racingcar.domain.User;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //NumberGenerator numberGenerator = new NumberGenerator();
        //System.out.println(numberGenerator.createRandomNumber());
        User user = new User();
        System.out.println(user.initCarList());
    }
}
