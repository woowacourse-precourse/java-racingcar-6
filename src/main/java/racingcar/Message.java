package racingcar;

import java.util.List;

public class Message {
    public static void startMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void countMessage() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void movingMessage(List<String> player) {

        for (int i = 0; i < player.size(); i++){
            System.out.println();
        }

    }
}
