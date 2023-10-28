package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.Racingcar_Game.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<String> carName = new ArrayList<>();
        carName = userInput();
        playGame(carName);
    }
}
