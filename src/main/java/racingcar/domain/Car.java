package racingcar.domain;

import static racingcar.domain.RacingConfig.FORWARD_HISTORY_MARK;
import static racingcar.domain.RacingConfig.FORWARD_NUMBER;

import java.util.List;

public class Car {
    private final String name;
    private int currentRound;
    private final int finalRound;
    private int movedDistance;
    private final List<String> movedHistory;

    public Car(String name, int currentRound, int finalRound, int movedDistance, List<String> movedHistory) {
        this.name = name;
        this.currentRound = currentRound;
        this.finalRound = finalRound;
        this.movedDistance = movedDistance;
        this.movedHistory = movedHistory;
    }

    public String getName() {
        return name;
    }
    public int getMovedDistance() {
        return movedDistance;
    }
    public List<String> getFormattedMovedHistory(){
        return this.movedHistory.stream()
                .map(history -> history.replaceAll("\\s+", ""))
                .toList();
    }

    public String generateMoveHistoryMark() {
        String history = String.join("", getFormattedMovedHistory());
        return String.format("%s : %s",this.name,history);
    }

    public void move(int generatedRandomNumber) {
        if (generatedRandomNumber >= FORWARD_NUMBER) {
            moveForward();
            increaseRound();
            return;
        }
        stayInplace();
        increaseRound();
    }
    private void moveForward() {
        this.movedDistance+= 1;
        this.movedHistory.add(FORWARD_HISTORY_MARK);
    }
    private void stayInplace() {
        this.movedHistory.add(" ");
    }

    private void increaseRound() {
        this.currentRound += 1;
    }
    public boolean hasMoreRound() {
        return this.currentRound < this.finalRound;
    }

    public boolean isWinner(int maxDistance) {
        return this.movedDistance == maxDistance;
    }
}
