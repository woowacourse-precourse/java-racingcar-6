package racingcar.view;

import java.util.List;

public class OutputView {
    public static void printExecResult() {
        System.out.println();
        System.out.println("실행 결과");
    }
    public static void printWinner(List<String> winnerName) {
        int winnerSize = winnerName.size();
        System.out.print("최종 우승자 : ");
        for(int i = 0; i < winnerSize - 1; i++) {
            System.out.print(winnerName.get(i));
            System.out.print(", ");
        }
        System.out.println(winnerName.get(winnerSize - 1));
    }
    public static void printCarStatus(List<String> carName, List<Integer> carStatus) {
        for(int i = 0; i < carName.size(); i++) {
            int status = carStatus.get(i);
            String name = carName.get(i);
            System.out.print(name);
            System.out.print(" : ");
            for(int j = 0; j < status; j++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void printInputCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static void printInputTryNum() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

}
