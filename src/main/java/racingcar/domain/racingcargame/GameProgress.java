package racingcar.domain.racingcargame;

public class GameProgress {


    // 게임 진행 상태 저장하는 필드
    String[] progress;

    // 랜덤으로 뽑힌 값을 저장하는 필드
    int count;


    public String[] getProgress() {
        return progress;
    }

    public void setProgress(String[] progress) {
        this.progress = progress;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
