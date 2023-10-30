package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  public static String getCarNamesFromPlayer() {
    ViewNotice.printGetCarNameNotice();
    return Console.readLine();
  }

  public static String getNumberOfRoundsFromPlayer() {
    ViewNotice.printGetRoundNotice();
    return Console.readLine();
  }
}
