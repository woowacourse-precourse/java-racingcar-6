package racingcar;

import java.util.List;

public class Script {
    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void askTry() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void showResult(List<String> names, List<StringBuilder> move) {
        for (int index = 0; index < names.size(); index++) {
            System.out.println(names.get(index) + " : " + move.get(index) + "/n");
        }
    }
}
