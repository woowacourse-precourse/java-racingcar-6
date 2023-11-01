package racingcar.view;

import java.util.List;

public class OutputView {
  public static void printSetCarName() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
  }

  public static void printSetCount() {
    System.out.println("시도할 횟수는 몇회인가요?");
  }

  public static void printStartRacing() {
    System.out.println("실행 결과");
  }

  public static void printRaceResult(String carName, int moveCount) {
    String move = "-".repeat(moveCount);
    System.out.println(carName + " : " + move);
  }

  public static void printRaceWinner(List<String> winners) {
    System.out.print("최종 우승자 : ");

    for (int i = 0; i < winners.size(); i++) {
      System.out.print(winners.get(i));

      if (i < winners.size() - 1) {
        System.out.print(", ");
      }
    }
  }
}
