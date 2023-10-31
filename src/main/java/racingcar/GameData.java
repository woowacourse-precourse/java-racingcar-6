package racingcar;

public class GameData {
    private final String[] carNames;
    private final int tryRoundCount;

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


}
