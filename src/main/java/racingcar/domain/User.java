package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

/**
 * 경주에 참여하는 주체
 */
public class User {
    private final String name;
    private int proceedCount;

    private User(String name) {
        this.name = name;
        this.proceedCount = 0;
    }

    public static User of(String name) {
        return new User(name);
    }

    public String getOutputMessage() {
        return name + " : " + visualizedCount();
    }

    private String visualizedCount() {
        return "-".repeat(Math.max(0, proceedCount));
    }

    public void proceedCar() {
        this.proceedCount++;
    }

    /**
     * 차가 움직일지 결정
     */
    public void decideProceed() {
        int randomNum = Randoms.pickNumberInRange(0, 9);
        if (randomNum >= 4) proceedCar();
    }

    public String getName() {
        return name;
    }

    public boolean isFasterThen(List<User> winner) {
        if (winner.isEmpty()) return true;
        return winner.stream().anyMatch(user -> this.proceedCount >= user.getProceedCount());
    }
    public int getProceedCount() {
        return this.proceedCount;
    }
}
