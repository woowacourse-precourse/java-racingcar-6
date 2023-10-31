package controller;

import java.util.List;
import model.domain.Name;
import model.domain.Round;
import model.domain.Winner;
import model.service.GameResult;
import model.service.InputCheck;
import model.domain.Participant;
import model.service.Game;
import view.Input;
import view.Output;

public class GameStart {

    public static void start() {

        String names = Input.name();
        List<String> nameList = InputCheck.name(names);
        Participant participant = new Participant(nameList);

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
