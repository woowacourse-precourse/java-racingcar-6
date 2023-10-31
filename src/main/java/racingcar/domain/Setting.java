package racingcar.domain;

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
