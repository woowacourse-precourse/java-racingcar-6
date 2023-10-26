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

        // for test
        for (Car participant : participants) {
            participant.Test();
        }
        System.out.println(repeat);
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
}
