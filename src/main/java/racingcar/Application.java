package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {

  public static void main(String[] args) {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    input = input.trim();

    String[] carNames = input.split(",");

    validateCarNames(carNames);

    System.out.println("시도할 회수는 몇회인가요?");
    int raceCount = Integer.parseInt(Console.readLine());

    validateRaceCount(raceCount);

    int[] winnerCounts = new int[carNames.length];

    System.out.println("실행 결과");

    for (int c = 0; c < raceCount; c++) {
      int[] moveCounts = new int[carNames.length];
      raceOneRound(carNames, moveCounts);
      updateWinnerCounts(winnerCounts, moveCounts);

      System.out.println("");
    }

    printWinners(carNames, winnerCounts);
  }

  private static void validateCarNames(String[] carNames) {
    for (String value : carNames) {
      if (value.trim().length() > 5) {
        throw new IllegalArgumentException("길이가 5 이상인 값이 감지되었습니다: " + value);
      }
    }
  }

  private static void validateRaceCount(int raceCount) {
    if (raceCount <= 0) {
      throw new IllegalArgumentException("횟수는 양수여야 합니다.");
    }
  }

  private static void raceOneRound(String[] carNames, int[] moveCounts) {
    for (int i = 0; i < carNames.length; i++) {
      int moveCnt = 0;
      for (int j = 0; j < carNames.length; j++) {
        int threshold = Randoms.pickNumberInRange(0, 9);
        if (threshold >= 4) {
          moveCnt++;
        }
      }

      String result = carNames[i] + " : " + "-".repeat(moveCnt);
      System.out.println(result);

      moveCounts[i] = moveCnt;
    }
  }

  private static void updateWinnerCounts(int[] winnerCounts, int[] moveCounts) {
    int maxMoveCnt = 0;
    for (int moveCount : moveCounts) {
      if (moveCount > maxMoveCnt) {
        maxMoveCnt = moveCount;
      }
    }

    for (int i = 0; i < winnerCounts.length; i++) {
      if (moveCounts[i] == maxMoveCnt) {
        winnerCounts[i]++;
      }
    }
  }

  private static void printWinners(String[] carNames, int[] winnerCounts) {
    int maxWinnerCnt = 0;
    for (int winnerCount : winnerCounts) {
      if (winnerCount > maxWinnerCnt) {
        maxWinnerCnt = winnerCount;
      }
    }

    System.out.print("최종 우승자 : ");

    boolean flag = false;

    for (int i = 0; i < carNames.length; i++) {
      if (winnerCounts[i] == maxWinnerCnt) {
        if (!flag) {
          flag = true;
        } else {
          System.out.print(", ");
        }
        System.out.print(carNames[i]);
      }
    }
  }
}