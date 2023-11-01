package racingcar.domain;

/**
 * 자동차 경주 진행을 위한 데이터를 담는 클래스
 */
public class Setting {
    private Names names;
    private Trial trial;

    public void setNames(String names) {
        this.names = new Names(names);
    }

    public void setTrial(String trial) {
        this.trial = new Trial(trial);
    }

    public int getTrial() {
        return trial.toNum();
    }

    public Cars toCars() {
        return names.toCars();
    }
}
