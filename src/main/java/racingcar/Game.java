package racingcar;

public class Game {

    public static final String RESULT_MESSAGE = "실행 결과";
    private String inputRacerName;
    private String[] racerNameArray;
    private int round;
    private User user;
    private Racing racing;

    public Game() {
        user = new User();
        inputRacingCarName();
        inputRacingRound();
        racing = new Racing(racerNameArray, round);
    }

    private void inputRacingCarName() {
        this.inputRacerName = user.inputCarName();
        this.racerNameArray = inputRacerName.split(",");
    }

    private void inputRacingRound() {
        this.round = user.inputRound();
    }

    public void startRacingGame() {
        System.out.println();
        System.out.println(RESULT_MESSAGE);
        racing.carRacingGameStart();
        racing.carRacingGameResult();
    }
}
