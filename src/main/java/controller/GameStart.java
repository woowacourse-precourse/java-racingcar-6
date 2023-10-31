package controller;

import java.util.List;
import model.domain.Round;
import model.domain.Winner;
import model.service.GameResult;
import model.service.InputCheck;
import model.domain.Participant;
import model.service.Game;
import model.service.Split;
import view.Input;
import view.Output;

public class GameStart {

    public static void start() {

        Participant participant = new Participant(Split.byComma(Input.name()));

        String roundStr = Input.round();
        int num = InputCheck.round(roundStr);
        Round round = new Round(num);

        Output.startResult();
        for (int i = 0; i < round.getRound(); i++) {
            Game.play(participant);
            Output.roundResult(participant);
        }

        Winner winner = GameResult.winner(participant);
        Output.finalResult(winner);
    }
}
