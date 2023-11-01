package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
  public static String setCarName() {
    return Console.readLine();
  }

  public static int setCount() {
    return Integer.parseInt(Console.readLine());
  }
}
