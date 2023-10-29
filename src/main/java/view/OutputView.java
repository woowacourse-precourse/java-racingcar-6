package view;

import java.util.HashMap;

public class OutputView {
    public void printRequestCarsName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printRequestPlayTime() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printStartGame() {
        System.out.println("\n실행 결과");
    }

    public void printCarsMove(HashMap<String, String> carNameAndPosList) {
        for(String name : carNameAndPosList.keySet()) {
            System.out.println(name + " : " + carNameAndPosList.get(name));
        }
        System.out.println();
    }
}
