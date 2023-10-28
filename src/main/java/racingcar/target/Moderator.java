package racingcar.target;

import java.util.List;

/*
 * 게임 진행자가 하는 일을 다루는 클래스
 */
public class Moderator {
    public void printNameInputMsg() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryInputMsg() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        }
    }
}
