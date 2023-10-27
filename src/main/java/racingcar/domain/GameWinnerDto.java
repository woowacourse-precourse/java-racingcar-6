package racingcar.domain;

public class GameWinnerDto {

    private String winnerCar;

    public GameWinnerDto(String winnerCar) {
        this.winnerCar = winnerCar;
    }

    public String getWinnerCar() {
        return winnerCar;
    }
}
