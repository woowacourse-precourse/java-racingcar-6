package racingcar;

public class Application {

    public static void main(String[] args) {

        // 경기 시작 전
        InputRacingInfo inputRacingInfo = new InputRacingInfo();
        RacingInfo racingInfo = inputRacingInfo.createRacingInfo();

        // 경기 진행
        RepeatRacing repeatRacing = new RepeatRacing();
        int[] statusCarMovement = repeatRacing.startRacing(racingInfo);

        // 경기 종료 후
        FindWinner findWinner = new FindWinner();
        findWinner.findWinner(racingInfo.carNames, statusCarMovement);
    }
}
