package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    private String racingCarName;
    private List<Boolean> racingCarMove;

    public RacingCar(final String racingCarName) {
        this.racingCarName = racingCarName;
        this.racingCarMove= new ArrayList<>();
    }

    public void isRacingCarMove(final int randomNumber) {
        if (randomNumber > 3) {
            this.racingCarMove.add(true);
        }
    }

    public String makeGameResult() {
        if (this.racingCarMove.isEmpty()) {
            return "";
        }
        String gameResult = "";
        for (int i = 0; i < this.racingCarMove.size(); i++) {
            if (this.racingCarMove.get(i).equals(true)) {
                gameResult += "-";
            }
        }
        return gameResult;
    }

    public String getRacingCarName() {
        return this.racingCarName;
    }

    public List<Boolean> getRacingCarMove() {
        return this.racingCarMove;
    }
    @Override
    public String toString() {
        String gameResult = makeGameResult();

        return this.racingCarName + " : " + gameResult;
    }
}
