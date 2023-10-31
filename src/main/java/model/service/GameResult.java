package model.service;

import java.util.ArrayList;
import java.util.List;
import model.domain.Car;
import model.domain.Go;
import model.domain.Name;
import model.domain.Participant;
import model.domain.Winner;

public class GameResult {

    public static Winner winner(Participant participant) {

        Winner winner = new Winner();
        int winnerGoValue = 0;

        for (Car car : participant.getParticipant()) {

            Go go = car.getGo();
            if (go.getGo() > winnerGoValue) {
                winner.clear();
                winnerGoValue = go.getGo();
            }
            if (go.getGo() == winnerGoValue) {
                winner.add(car.getName());
            }
        }

        return winner;
    }

}
