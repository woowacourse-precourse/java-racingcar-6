package racingcar.view;

import java.util.List;

public class OutputView {
    public void printCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printHowManyRound() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printGameStart() {
        System.out.println("");
        System.out.println("실행결과");
    }

    public void printRoundResult(String carName, int currentPosition) {
        System.out.print(carName + " : ");

        for (int i = 0; i < currentPosition; i++) {
            System.out.print("-");
        }

        System.out.println("");
    }

    public void printRoundResults(List<String> carNames, List<Integer> currentCarPositions) {
        for (int j = 0; j < carNames.size(); j++) {
            System.out.print(carNames.get(j) + " : ");

            for (int i = 0; i < currentCarPositions.get(j); i++) {
                System.out.print("-");
            }

            System.out.println("");
        }
        System.out.println("");

    }

    public void printWinner(List<String> winners) {
        int winnerNumber = winners.size();

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winnerNumber - 1; i++) {
            System.out.print(winners.get(i) + ", ");
        }
        System.out.println(winners.get(winnerNumber - 1));
    }
}
