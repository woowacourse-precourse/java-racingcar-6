package racingcar;

import racingcar.domain.NumberGenerator;
import racingcar.domain.User;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //디버깅 용 코드 , 구현 후 삭제할것
        NumberGenerator numberGenerator = new NumberGenerator();
        int a = numberGenerator.createRandomNumber();
        System.out.println(a);
        User user = new User();
        System.out.println(user.decideMove(a));
    }
}
