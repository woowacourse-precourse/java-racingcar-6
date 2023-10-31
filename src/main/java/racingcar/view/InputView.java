package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class InputView {

  public String[] getCarNames() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String inputName = Console.readLine();
    String[] carNames = inputName.split(",");
    Set<String> uniqueNames = new HashSet<>();
    for (String name : carNames) {
      String trimmedName = name.trim();
      if (trimmedName.isEmpty() || trimmedName.length() > 5) {
        throw new IllegalArgumentException("자동차 이름은 1글자 이상, 5글자 이하여야 한다.");
      }
      if (!uniqueNames.add(trimmedName)) {
        throw new IllegalArgumentException("중복된 자동차 이름이 있으면 안 된다.");
      }
    }
    return carNames;
  }

  public int getMoveCount() {
    System.out.println("시도할 회수는 몇회인가요?");
    int inputCount = Integer.parseInt(Console.readLine());
    if (inputCount <= 0) {
      throw new IllegalArgumentException("시도할 회수는 1이상이어야 한다.");
    }
    return inputCount;
  }
}
