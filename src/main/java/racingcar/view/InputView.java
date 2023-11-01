package racingcar.view;


import static racingcar.constant.ViewConstants.GET_CARNAME_NOTICE;
import static racingcar.constant.ViewConstants.GET_ROUND_NOTICE;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

  public static String getCarNamesFromPlayer() {
    System.out.println(GET_CARNAME_NOTICE);
    return Console.readLine();
  }

  public static String getNumberOfRoundsFromPlayer() {
    System.out.println(GET_ROUND_NOTICE);
    return Console.readLine();
  }
}

