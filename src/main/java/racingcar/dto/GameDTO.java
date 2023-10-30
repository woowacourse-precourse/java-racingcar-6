package racingcar.dto;

public class GameDTO {
    private int CAR_AMOUNT, MAX_ROUND;


    public GameDTO(int amount, int round) {
        this.CAR_AMOUNT = amount;
        this.MAX_ROUND = round;
    }


    public int getCarAmount() {
        return CAR_AMOUNT;
    }

    public int getMaxRound() {
        return MAX_ROUND;
    }

}
