package controller;

import model.domain.Round;
import model.domain.Winner;
import model.service.GamePlay;
import model.service.GameResult;
import model.domain.Participant;
import view.Input;
import view.Output;

public class GameStart {

    public static void start() {

        Participant participant = new Participant(Input.name());
        Round round = new Round(Input.round());

        Output.startResult();
        for (int i = 0; i < round.getRound(); i++) {
            GamePlay.round(participant);
            Output.roundResult(participant);
        }

        Winner winner = GameResult.winner(participant);
        Output.finalResult(winner);
    }
}
