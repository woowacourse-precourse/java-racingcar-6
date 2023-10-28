package racingcar;

import java.util.HashMap;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        CarNameInput carNameInput = new CarNameInput();

        HashMap<String,Integer> userResult = carNameInput.inputCarName();

    }
}
