package racingcar.play.game;

import racingcar.play.car.Car;
import racingcar.play.user.User;

public class Game {

    public static void start(){
        //사용자로부터 자동차 이름 입력
        String[] names = Car.input();

        //사용자로부터 시도 회수 입력
        int count = User.input();
    }

}
