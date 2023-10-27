package racingcar;

import java.util.List;
import racingcar.domain.Input;


public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> carNames = Input.readCarName();
        System.out.println(carNames.size());
        System.out.println(carNames);
    }
}