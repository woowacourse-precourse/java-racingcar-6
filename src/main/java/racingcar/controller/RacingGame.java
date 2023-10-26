package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.MoveInfo;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> participants = new ArrayList<>();
    private int repeat;

    public void start() {
        setParticipants();
        setRepeat();

        OutputView.printResultTitle();
        while (repeat-- > 0) {
            move();
        }

        finishGame();
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
            OutputView.printResult(participant.info());
        }
        System.out.println();
    }

    private void finishGame() {
        int maxMoved = -1;
        List<String> names = new ArrayList<>();

        for (Car participant : participants) {
            MoveInfo info = participant.info();
            if (info.moved > maxMoved) {
                maxMoved = info.moved;
                names = new ArrayList<>();
                names.add(info.name);
            } else if (info.moved == maxMoved) {
                names.add(info.name);
            }
        }

        OutputView.printFinalWinner(names);
    }
}
