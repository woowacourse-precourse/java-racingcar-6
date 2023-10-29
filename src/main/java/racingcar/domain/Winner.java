package racingcar.domain;

import java.util.List;

public class Winner {
    private static final String COMMA = ", ";
    private String winnerRacingCar;

    public String getWinnerRacingCar() {
        return winnerRacingCar;
    }

    public Winner(List<RacingCar> racingCarList) {
        int winnerValue = getWinnerValue(racingCarList);
        this.winnerRacingCar = whoIsWinner(racingCarList, winnerValue);
    }

    public String whoIsWinner(List<RacingCar> racingCarList, int winnerValue) {
        return racingCarList.stream()
                .filter(car -> car.getMove() == winnerValue)
                .map(RacingCar::getName)
                .reduce((name1, name2) -> name1 + COMMA + name2)
                .orElse("");
    }

    private Integer getWinnerValue(List<RacingCar> racingCarList) {
        return racingCarList
                .stream()
                .mapToInt(RacingCar::getMove)
                .max()
                .orElse(0);
    }
}
