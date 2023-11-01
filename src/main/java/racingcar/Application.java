package racingcar;

import racingcar.entity.MovePolicy;
import racingcar.entity.policy.RandomMovePolicy;

public class Application {

    public static void main(String[] args) {
        Controller controller = new Controller(movePolicy());

        controller.run();
    }

    private static MovePolicy movePolicy() {
        return new RandomMovePolicy();
    }
}
