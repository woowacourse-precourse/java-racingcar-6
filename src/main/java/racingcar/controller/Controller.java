package racingcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import racingcar.view.Input;
import racingcar.view.Output;
import racingcar.model.Referee;
import racingcar.model.Round;

public class Controller {
    private Integer roundCount;
    private List<String> carNames;
    private List<Integer> carMoves = new ArrayList<>();

    public void play() {
        this.setSettings();
        this.playAllRound();
        this.end();
    }

    private void setSettings() {
        this.carNames = Input.readCarName();
        IntStream.range(0, carNames.size()).forEach(i -> this.carMoves.add(0));
        this.roundCount = Input.readRoundCount();
    }

    private void playAllRound() {
        Output.printResultTitle();

        for (int i = 0; i < this.roundCount; i++) {
            this.playOneRound();
        }
    }

    private void playOneRound() {
        Round round = new Round(this.carMoves);
        this.carMoves = round.carMoves();
        Output.printRoundResult(this.carNames, this.carMoves);
    }

    private void end() {
        Referee referee = new Referee(this.carNames, this.carMoves);
        List<String> winners = referee.getWinners();
        Output.printWinner(winners);
    }
}
