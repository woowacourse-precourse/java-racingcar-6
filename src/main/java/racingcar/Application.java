package racingcar;

import racingcar.model.Race;
import racingcar.model.User;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        List<String> carNameList = user.inputCarName();
        int count = user.inputCount();

        System.out.println("\n실행 결과");
        Race race = new Race();
        race.racingCar(count, carNameList);

    }
}
