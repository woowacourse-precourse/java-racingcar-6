package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
  public static void main(String[] args) {

  }

  private static String[] getCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = readLine().trim();
    String[] carNames = input.split(",");

    for (int i = 0; i < carNames.length; i++) {
      carNames[i] = carNames[i].trim();
      if (carNames[i].isEmpty() || carNames[i].length() > 5) {
        throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
      }
    }
    return carNames;
  }

  private static int getNumberOfAttempts() {
    System.out.println("시도할 횟수는 몇회인가요?");
    int numAttempts = Integer.parseInt(readLine());
    if (numAttempts <= 0) {
      throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
    }
    System.out.println();
    return numAttempts;
  }

  private static int[] raceCars(String[] carNames, int numAttempts) {
    int numCars = carNames.length;
    int[] positions = new int[numCars];

    for (int attempt = 1; attempt < numAttempts; attempt++) {
      for (int i = 0; i < numCars; i++) {
        int randomValue = Randoms.pickNumberInRange(0, 9);
        if (randomValue >= 4) {
          positions[i]++;
        }
      }
    }
    return positions;
  }

  private static void displayCarPositions(String[] carNames, int[] positions) {

    for (int i = 0; i < carNames.length; i++) {
      System.out.print(carNames[i] + ": ");
      for (int j = 0; j < positions[i]; j++) {
        System.out.print("-");
      }
      System.out.println();
    }
    System.out.println();
  }

  private static void announceWinners(String[] carNames, int[] positions) {
    int maxPosition = 0;
    for (int position : positions) {
      if (position > maxPosition) {
        maxPosition = position;
      }
    }

    System.out.print("최종 우승자 : ");
    boolean isFirstWinner = true;
    for (int i = 0; i < carNames.length; i++) {
      if (positions[i] == maxPosition) {
        if (!isFirstWinner) {
          System.out.print(", ");
        }
        System.out.print(carNames[i]);
        isFirstWinner = false;
      }
    }
  }
}
