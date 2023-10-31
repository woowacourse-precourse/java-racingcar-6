package racingcar.domain;

import java.util.List;

public class Winners {

    private static final String FINAL_WINNERS = "최종 우승자 : ";
    private List<Position> positions;
    private int tryCnt;

    private Winners(List<Position> positions, int tryCnt) {
        this.positions = positions;
        this.tryCnt = tryCnt;
    }

    public static Winners createWinners(List<Position> positions, int tryCnt) {
        return new Winners(positions, tryCnt);
    }

    public void getWinnersList() {
        StringBuilder winners = new StringBuilder();
        for (Position position : this.positions) {
            if (position.distanceValue() == this.tryCnt) {
                if (winners.length() > 0) {
                    winners.append(", ");
                }
                winners.append(position.carInfo());
            }
        }
        System.out.print(FINAL_WINNERS + winners.toString());
    }
}
