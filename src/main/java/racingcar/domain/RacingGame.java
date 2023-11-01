package racingcar.domain;

import static racingcar.utils.StringUtils.readParticipantCars;

import java.util.ArrayList;
import java.util.List;
import racingcar.view.GameView;

public class RacingGame {

    List<Car> participants = new ArrayList<>();
    List<String> winners = new ArrayList<>();

    public void start() {
        String participantNames = GameView.getParticipants();
        participants = readParticipantCars(participantNames);

        int times = GameView.getRacingTimes();

        GameView.printGames(times, participants);

        checkWinner();

        GameView.printWinners(winners);
    }

    private void checkWinner() {
        for (Car participant : participants) {
            if (Car.maxDistance == participant.getDistance()) {
                winners.add(participant.getName());
            }
        }
    }
}