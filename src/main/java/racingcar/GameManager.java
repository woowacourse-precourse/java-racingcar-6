package racingcar;

import racingcar.messages.Message;

import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private final List<Car> cars = new ArrayList<>();

    public void start() {
        System.out.println(Message.GAME_START_NAME);
    }
}
