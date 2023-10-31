package racingcar;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        CarNames carNames = new CarNames();
        Message.startMessage();
        List<String> playerList = carNames.inputCarNames();
        System.out.println(playerList);

        InputMovingcount inputMovingCount = new InputMovingcount();

        Message.countMessage();
        int MovingCount = inputMovingCount.inputMovingCount();
        System.out.println(MovingCount);

    }
}
