package racingcar;

public class Announcer {
    private final String INPUT_CAR_NAME = "경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";

    public void announceToInputCarName() {
        print(INPUT_CAR_NAME);
    }

    public void announceToInputTryCount() {
        print(INPUT_TRY_COUNT);
    }

    public void print(String message) {
        System.out.println(message);
    }
}
