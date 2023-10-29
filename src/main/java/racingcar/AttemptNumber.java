package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class AttemptNumber {
  public int Attempt() {

    System.out.println("시도할 회수는 몇회인가요?");
    int attempt = 0;
    String number = Console.readLine();

    attempt = parseAttempt(number);
    validateAttempt(attempt);

    return attempt;

  }

  private int parseAttempt(String input) {
    try {
      return Integer.parseInt(input);
    } catch (NumberFormatException e) {
      throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
    }
  }

  private void validateAttempt(int attempt) {
    if (attempt < 1) {
      throw new IllegalArgumentException("1 이상의 숫자를 입력하세요.");
    }
  }
}
