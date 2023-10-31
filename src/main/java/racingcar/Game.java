package racingcar;

public class Game {

    private String inputRacerName;
    private String[] racerNameArray;
    private int round;
    private User user;
    private Racing racing;

    public Game() {
        user = new User(); // 생성 주입 순서.. 필드주입, 생성자주입..(보통선호)
        inputRacingCarName();
        inputRacingRound();
        racing = new Racing(racerNameArray, round); // ["pobi", "woni"], 5
    }

    public void inputRacingCarName() {
        this.inputRacerName = user.inputCarName();
        this.racerNameArray = inputRacerName.split(",");
    }

    public void inputRacingRound() {
        this.round = user.inputRound();
    }

    public void startRacingGame() {
        System.out.println();
        System.out.println("실행 결과");
        racing.CarRacingGameStart();
    }
}
