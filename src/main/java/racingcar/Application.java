package racingcar;

import racingcar.entity.policy.RandomMovePolicy;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(new RandomMovePolicy());

        controller.run();
    }
}
