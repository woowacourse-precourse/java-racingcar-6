package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
  public String[] getCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine().trim();
    String[] carNames = input.split(",");

    for (int i = 0; i < carNames.length; i++) {
      carNames[i] = carNames[i].trim();
      if (carNames[i].isEmpty() || carNames[i].length() > 5) {
        throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
      }
    }
    return carNames;
  }

  public int getNumAttempts() {
    System.out.println("시도할 횟수는 몇회인가요?");
    int numAttempts = Integer.parseInt(Console.readLine());
    if (numAttempts <= 0) {
      throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
    }
    System.out.println();
    return numAttempts;
  }
}
