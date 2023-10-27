package racingcar.domain;

import java.util.List;

public class RacingCarGame {
    private int number;
    private boolean gameState;
    private List<RacingCar> racingCarList;

    public RacingCarGame(int number ,List<RacingCar> racingCarList) {
        this.number = number;
        this.gameState = true;
        this.racingCarList = racingCarList;
    }

    public List<RacingCar> getRacingCarList() {
        return racingCarList;
    }

    public boolean isGameState() {
        return gameState;
    }

    private void gameSetCheck() {
        if (this.number == 0) {
            this.gameState = false;
        }
    }

    private void setNumber() {
        this.number -= 1;
    }

    public void repeatMovingRacingCar() {
        racingCarList.stream().forEach(RacingCar::moveRacingCar);
        setNumber();
        gameSetCheck();
    }


    public String whoIsWinner() {
        return racingCarList.stream()
                .filter(car -> car.getMove() == winnerValue())
                .map(RacingCar::getName)
                .reduce((name1, name2) -> name1 + "," + name2)
                .orElse("");
    }

    private Integer winnerValue() {
        return racingCarList.stream().mapToInt(RacingCar::getMove).max().orElse(0);
    }
}
