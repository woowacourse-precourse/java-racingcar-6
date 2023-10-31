package racingcar.domain;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.ArrayList;
import java.util.List;

public class Ask {
  public static List<String> askCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

    List<String> validWords = new ArrayList<>();
    List<String> input = List.of(readLine().split(","));

    for (String str : input) {
      if (str.length() <= 5) {
        validWords.add(str);
      } else {
        throw new IllegalArgumentException();
      }
    }
    return validWords;
  }

  public static int askAttemptsOfNum() {
    System.out.println("시도할 회수는 몇회인가요?");

    int attempt;

    try {
      attempt = Integer.parseInt(readLine());
    } catch (Exception e) {
      throw new IllegalArgumentException();
    }
    return attempt;
  }
}
