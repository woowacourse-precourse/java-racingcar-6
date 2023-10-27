package racingcar;

import java.util.List;

public class RunningMessage {
    public void printStartMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
    }

    public void printHowManyGame() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printCarName(String carName) {
        System.out.print(carName + " : ");
    }

    public void printRunCount(int runCount) {
        for (int i = 0; i < runCount; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printWinner(List<String> winner) {
        System.out.print("최종 우승자 : ");
        for (int index = 0; index < winner.size(); index++) {
            if (index + 1 != winner.size()) {
                System.out.print(winner.get(index) + ", ");
            } else {
                System.out.println(winner.get(index));
            }
        }
    }

}
