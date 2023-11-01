package racingcar.view;

import java.util.List;

public class OutputView {
    private static final String FORWARD_SYMBOL = "-";

    public void printProcess(List<String> cars, List<Integer> processResult, int attemptCount) {
        System.out.println("실행 결과");
        // 시도할 횟수 만큼 반복하면서
        // 각 차에 대해 결과 출력
        for (int i=0; i<attemptCount; i++) {
            printSingleProcess(cars, processResult, cars.size());
            System.out.println();
        }
    }

    public void printSingleProcess(List<String> cars, List<Integer> processResult, int carCount) {
        for (int i=0; i<carCount; i++) {
            // Todo
            // processResult는 2차원 배열이어야 할듯 그래서 더 고민 필요
            // 여기에서 바로 isForward()하는 게 좋을려나
        }
    }

    public void printWinners(List<String> winners) {
        StringBuilder output = new StringBuilder();
        output.append("최종 우승자 : ");
        for (String winner : winners) {
            output.append(winner);
            if (winners.indexOf(winner) < winners.size() - 1) {
                output.append(", ");
            }
        }
    }
}
