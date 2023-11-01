package racingcar.view;

import racingcar.util.Message;

public class OutputView {
    public void write(String message) {
        System.out.print(message);
    }

    public void showMove(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print(Message.MOVE_DISTANCE);
        }
    }
}