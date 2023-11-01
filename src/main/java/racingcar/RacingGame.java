package racingcar;

import java.util.ArrayList;
import java.util.Collections;

public class RacingGame {
    private ArrayList<Car> participants;
    private int countOfTotalMoves;

    private RacingGame() {
    }

    RacingGame(int CountOfTotalMoves) {
        this.countOfTotalMoves = CountOfTotalMoves;
        participants = new ArrayList<>();
    }

    private ArrayList<String> getWinners() {
        Collections.sort(this.participants);
        int winnerScore = this.participants.get(0).getCurrentLocation();
        ArrayList<String> winnerNameList = new ArrayList<>();

        for (Car participant : this.participants) {
            if (participant.getCurrentLocation() < winnerScore) {
                break;
            }
            winnerNameList.add(participant.getName());
        }
        return winnerNameList;
    }

    private void moveOnceForEachParticipants() {
        for (Car participant : this.participants) {
            participant.move();
            System.out.println(participant.getCurrentStatus());
        }
    }

    public void addParticipant(Car participant) {
        this.participants.add(participant);
    }

    public void game() {
        for (int currentMove = 0; currentMove < this.countOfTotalMoves; ++currentMove) {
            moveOnceForEachParticipants();
            System.out.println();
        }
    }

    public String getResult() {
        return "최종 우승자 : " + String.join(", ", this.getWinners());
    }
}
