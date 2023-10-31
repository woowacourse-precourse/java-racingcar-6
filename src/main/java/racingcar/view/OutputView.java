package racingcar.view;

import java.util.List;

public class OutputView {
    public static void printProgressStmt() {
        System.out.println("\n실행 결과");
    }

    public static void printOneTurnResult(List<String> cars, List<Integer> carPos) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cars.size(); i++) {
            sb.append(cars.get(i) + " : ");
            Integer distance = carPos.get(i);
            for (int j = 0; j < distance; j++) {
                sb.append("-");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void printWinnerResult(List<String> winner) {
        StringBuilder sb = new StringBuilder();
        sb.append("최종 우승자 : ");
        for (String w : winner) {
            sb.append(w + ", ");
        }
        sb.delete(sb.length() - 2, sb.length());
        System.out.println(sb);
    }
}
