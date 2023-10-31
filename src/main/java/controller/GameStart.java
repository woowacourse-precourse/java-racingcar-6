package controller;

import java.util.List;
import model.service.GameResult;
import model.service.InputCheck;
import model.domain.Participant;
import model.service.Round;
import view.Input;
import view.Output;

public class GameStart {

    public static void start() {

        String names = Input.name();
        List<String> nameList = InputCheck.name(names);
        Participant participant = new Participant(nameList);

        String roundStr = Input.round();
        int round = InputCheck.round(roundStr);

        Output.startResult();
        for (int i = 0; i < round; i++) {
            Round.play(participant);
            Output.roundResult(participant);
        }

        List<String> winner = GameResult.winner(participant);
        Output.finalResult(winner);
    }
}
