package racingcar;

import java.util.ArrayList;

public class Output {
    static void nameText() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    static void moveCountText() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    static void resultText() {
        System.out.println("실행 결과");
    }

    static void victoryText(ArrayList<String> name) {
        String result = "최종 우승자 : ";
        String names = String.join(", ", name);
        result = result + names;
        System.out.println(result);
    }

}
