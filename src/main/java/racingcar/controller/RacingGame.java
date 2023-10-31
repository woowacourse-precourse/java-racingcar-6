package racingcar.controller;

import racingcar.model.Car;
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

    private void setParticipants() {
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

    private void setRepeat() {
        String repeatString = InputView.inputRepeat();
        repeat = new RacingRepeat(repeatString);
    }

    private void move() {
        for (Car participant : participants) {
            participant.move();
            OutputView.printResult(participant.getName(), participant.getMoved());
        }
        System.out.println();
    }

    public List<String> getWinner(List<Car> target) {
        int maxMoved = Integer.MIN_VALUE;
        List<String> winner = new ArrayList<>();

        for (Car car: target) {
            String name = car.getName();
            int moved = car.getMoved();
            if (moved > maxMoved) {
                maxMoved = moved;
                winner = new ArrayList<>();
                winner.add(name);
            } else if (moved == maxMoved) {
                winner.add(name);
            }
        }
        return winner;
    }

    private void finishGame() {
        List<String> winner = getWinner(participants);
        OutputView.printFinalWinner(winner);
    }
}
