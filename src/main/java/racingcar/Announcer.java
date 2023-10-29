package racingcar;

public class Announcer {
    private final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";

    public void announceToInputCarName() {
        print(INPUT_CAR_NAME);
    }

    public void print(String message) {
        System.out.println(message);
    }
}
