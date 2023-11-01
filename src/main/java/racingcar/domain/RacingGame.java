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

        System.out.println("\n실행 결과");
        for (int i = 0; i < times; i++) {
            for (Car participant : participants) {
                participant.moveOrStay();
                participant.printSticks();
            }
            System.out.println();
        }

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