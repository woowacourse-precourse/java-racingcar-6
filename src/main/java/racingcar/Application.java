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

}
