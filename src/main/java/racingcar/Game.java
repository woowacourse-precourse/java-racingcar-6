package racingcar;

public class Game {

    private String inputRacerName;
    private String[] racerNameArray;
    private int round;
    private User user = new User();

    public void inputRacerName() { // Game -> User 자동차 입력을 해라.
        this.inputRacerName = user.inputCarName();
    }

    public void inputRacerNameSplit() {
        this.racerNameArray = inputRacerName.split(",");
    }

    public void inputRacingRound() {
        this.round = user.inputRound();
    }

    public void startRacingGame() {
    }
}
