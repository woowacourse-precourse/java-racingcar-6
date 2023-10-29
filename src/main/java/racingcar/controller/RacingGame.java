package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.MoveInfo;
import racingcar.model.RacingRepeat;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> participants = new ArrayList<>();
    private RacingRepeat repeat;

    public void start() {
        setParticipants();
        setRepeat();

        OutputView.printResultTitle();
        while (repeat.decrease()) {
            move();
        }

        finishGame();
    }

    public void setParticipants() {
        setParticipants(InputView.inputNames());
    }
    public List<Car> setParticipants(String[] names) {
        participants = new ArrayList<>();
        for (String name : names) {
            Car participant = new Car(name);
            participants.add(participant);
        }
        return participants;
    }

    public void setRepeat() {
        repeat = InputView.inputRepeat();
    }

    private void move() {
        for (Car participant : participants) {
            participant.move();
            OutputView.printResult(participant.info());
        }
        System.out.println();
    }

    public List<String> getWinner(List<Car> target) {
        int maxMoved = -1;
        List<String> winner = new ArrayList<>();

        for (Car car: target) {
            MoveInfo info = car.info();
            if (info.getMoved() > maxMoved) {
                maxMoved = info.getMoved();
                winner = new ArrayList<>();
                winner.add(info.getName());
            } else if (info.getMoved() == maxMoved) {
                winner.add(info.getName());
            }
        }
        return winner;
    }

    private void finishGame() {
        List<String> winner = getWinner(participants);
        OutputView.printFinalWinner(winner);
    }
}
