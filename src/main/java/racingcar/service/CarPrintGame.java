package racingcar.service;

import java.util.ArrayList;

public class CarPrintGame implements PrintGame {
    @Override
    public void printInit() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    @Override
    public void tryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    @Override
    public void printGame(String playerName, int goCount) {
        System.out.print(playerName + " : ");
        for (int loop = 0; loop < goCount; loop++) {
            System.out.print("-");
        }
        System.out.println();
    }

    @Override
    public void printWinner(ArrayList<String> names) {
        System.out.print("최종 우승자 : ");
        //마지막에서 한명을 제외하고 ", " 형식으로 뽑기위해서 -2를 사용한다
        for (int loop = 0; loop < names.size() - 1; loop++) {
            System.out.print(names.get(loop) + ", ");
        }
        System.out.print(names.get(names.size() - 1));
    }
}
