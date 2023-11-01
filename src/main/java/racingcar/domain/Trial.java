package racingcar.domain;

import racingcar.util.Validator;

/**
 * 시도 횟수를 담는 클래스
 */
public class Trial {
    private String trial;

    /**
     * Trial 생성자
     * <p>
     * 입력값을 검증하고 초기화<br> 앞뒤 공백은 사용자 실수로 간주하고 제거
     *
     * @param trial 입력값
     */
    public Trial(String trial) {
        String test = trial.trim();
        new Validator().trial(test);
        this.trial = test;
    }

    public int toNum() {
        return Integer.valueOf(trial);
    }
}
