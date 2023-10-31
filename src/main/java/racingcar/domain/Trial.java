package racingcar.domain;

import racingcar.util.Validator;

public class Trial {
    private String trial;

    public Trial(String trial) {
        String test = trial.trim();
        new Validator().trial(test);
        this.trial = test; //검증 받은 시도 횟수
    }

    public int toNum() {
        return Integer.valueOf(trial);
    }

}
