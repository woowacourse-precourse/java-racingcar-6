package model.service;

import model.domain.Car;
import model.domain.Go;
import model.domain.Participant;
import model.domain.Winner;

public class GameResult {

    public static Winner winner(Participant participant) {

        Winner winner = new Winner();
        int winnerGoValue = 0;

        for (Car car : participant.getParticipant()) {

            int currentGoValue = car.getGoValue();

            if (currentGoValue > winnerGoValue) {
                winner.clear();
                winnerGoValue = currentGoValue;
            }
            if (currentGoValue == winnerGoValue) {
                winner.add(car.getName());
            }
        }

        return winner;
    }

}
