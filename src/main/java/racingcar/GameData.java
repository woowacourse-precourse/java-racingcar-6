package racingcar;

public class GameData {
    private final String[] carNames;
    private final int tryRoundCount;
    private int currentRound;

    public GameData(String[] carNames, int tryCount) {
        this.carNames = carNames;
        this.tryRoundCount = tryCount;
    }
    //입력 받은 차들의 이름들 반환
    public String[] getCarNames() {
        return carNames;
    }
    // 최종 라운드 수 반환
    public int getTryCount() {
        return tryRoundCount;
    }

    // 현재 라운드 수를 반환
    public int getCurrentRound() {
        return currentRound;
    }

    // 다음 라운드로 진행.
    public void nextRound() {
        if (currentRound < tryRoundCount) {
            currentRound++;
        }
    }

    // 모든 라운드가 완료되었는지 확인
    public boolean isRacesFinished() {
        return currentRound >= tryRoundCount;
    }
}
