package racingcar;

import java.sql.SQLSyntaxErrorException;
import java.util.ArrayList;
import java.util.List;

enum WinnerType{
    JOINT, SINGLE;
}
public class Winner {
    private List<String> winner;
    private WinnerType winnerType;
    public Winner(List<String> winner, WinnerType winnerType) {
        this.winner = winner;
        this.winnerType = winnerType;
    }
    public static Winner createWinner(List<RacingCar> racingCars) {
        int max = 0;
        List<String> winners = new ArrayList<String>();

        for (RacingCar racingCar : racingCars) {
            if (racingCar.getPosition() > max) {
                winners.clear();
                winners.add(racingCar.getName());
            } else if (racingCar.getPosition() == max) {
                winners.add(racingCar.getName());
            }
        }

        if (winners.size() == 1) {
            return new Winner(winners, WinnerType.SINGLE);
        } else {
            return new Winner(winners, WinnerType.JOINT);
        }
    }
    public void viewWinner() {
        String finalWinner;
        if (this.winnerType == WinnerType.SINGLE) {
            finalWinner = viewSingleWinner();
        } else {
            finalWinner = viewJointWinner();
        }
        System.out.println("최종 우승자 : "+finalWinner);
    }

    private String viewSingleWinner() {
        return winner.get(0);
    }

    private String viewJointWinner() {
        return String.join(",",winner);
    }
}
