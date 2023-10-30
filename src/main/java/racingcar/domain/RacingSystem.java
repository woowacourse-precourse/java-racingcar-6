package racingcar.domain;

import java.util.List;

public class RacingSystem {
    User user = new User();
    private List<String> carNames;
    private int movement;

    public void startApp() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        this.carNames = user.inputCarName();
        System.out.println("시도할 회수는 몇회인가요?");
        this.movement = user.inputNumberOfCarMovement();
    }
}
