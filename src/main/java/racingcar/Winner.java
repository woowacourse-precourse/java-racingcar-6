package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Winner {
    private List<String> winerList = new ArrayList<>();
    private int winnerPosition;
    public Winner(List<Car> winners) {
        winnerPosition = Arrays.stream(winners.toArray())
                .mapToInt(car -> ((Car) car).getPosition())
                .max()
                .getAsInt();
        setWinnerList(winners);
        printWinner();
    }
    private void printWinner() {
        Message.printWinnerMessage();
        for (int i = 0; i < winerList.size(); i++) {
            System.out.print(winerList.get(i));
            if (i != winerList.size() - 1) {
                System.out.print(", ");
            }
        }
    }
    private void setWinnerList(List<Car> winners) {
        for (int i = 0; i < winners.size(); i++) {
            if (winners.get(i).getPosition() == winnerPosition) {
                winerList.add(winners.get(i).getName());
            }
        }
    }
}
