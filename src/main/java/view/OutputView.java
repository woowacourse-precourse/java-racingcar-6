package view;

import java.util.List;

public class OutputView {
    public static void printRacingCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }
    public static void printNumberOfRacing() {
        System.out.println("시도할 회수는 몇회인가요?");

    }
    public static void printRacingResult(List<String>carName, List<Integer>raceResult) {
        System.out.println("실행 결과");
        for(int i = 0; i < carName.size(); i++) {
        System.out.print(carName.get(i));
            while(i < raceResult.size()) {
                System.out.print('-');
            }
            System.out.println();
        }

    }
    public static void printRacingWinner(List<String>winnerName) {
    String winner = String.join(", ", winnerName);
    System.out.println(winner);
    }
}
