package racingcar.View;

import camp.nextstep.edu.missionutils.Console;

public class TextInterface {
    public String enterPlayer() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public String enterRepetition() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }

    public void printDistance(String name, int distance) {
        System.out.print(name + " : ");
        for (int i = 0; i < distance; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printExcution() {
        System.out.println("\n실행 결과");
    }

    public void printResult() {
        System.out.print("최종 우승자 : ");
    }


    public void printWinner(String name) {
        System.out.print(name);
    }

    public void printJointWinner(String name) {
        System.out.print(", " + name);
    }
}
