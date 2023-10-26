package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> participants = new ArrayList<>();
    private int repeat;

    public void start() {
        setParticipants();
        setRepeat();
        while (repeat-- > 0) {
            move();
            test();
        }
    }

    private void setParticipants() {
        participants = new ArrayList<>();
        String[] names = InputView.inputNames();
        for (String name : names) {
            Car participant = new Car(name);
            participants.add(participant);
        }
    }

    private void setRepeat() {
        repeat = InputView.inputRepeat();
    }

    private void move() {
        for (Car participant : participants) {
            participant.move();
        }
    }

    private void test() {
        // for test
        for (Car participant : participants) {
            participant.test();
        }
    }
}
