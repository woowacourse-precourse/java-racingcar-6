package model.service;

import java.util.ArrayList;
import java.util.List;
import model.domain.Car;
import model.domain.Name;
import model.domain.Participant;

public class GameResult {

    public static List<Name> winner(Participant participant) {

        List<Name> winner = new ArrayList<>();
        int winnerGoValue = 0;

        for (Car car : participant.getParticipant()) {
            if (car.getGo() > winnerGoValue) {
                winner.clear();
                winnerGoValue = car.getGo();
            }
            if (car.getGo() == winnerGoValue) {
                winner.add(car.getName());
            }
        }

        return winner;
    }

}
