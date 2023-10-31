package racingcar;

public class Application {

    public static void main(String[] args) {

        // 경기 시작 전
        RequestRacing requestRacing = new RequestRacing();
        RacingInfo racingInfo = requestRacing.createRacingInfo();

        // 경기 진행
        DoRacing doRacing = new DoRacing();
        int[] statusCarMovement = doRacing.startRacing(racingInfo);

        // 경기 종료 후
        FindWinner findWinner = new FindWinner();
        findWinner.findWinner(racingInfo.carNames, statusCarMovement);
    }
}
