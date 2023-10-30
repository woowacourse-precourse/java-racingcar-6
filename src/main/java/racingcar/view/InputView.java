package racingcar.view;


import camp.nextstep.edu.missionutils.Console;

public class InputView {

  public static String getCarNamesFromPlayer() {
    System.out.println(ViewNotice.GET_CARNAME_NOTICE);
    return Console.readLine();
  }

  public static String getNumberOfRoundsFromPlayer() {
    System.out.println(ViewNotice.GET_ROUND_NOTICE);
    return Console.readLine();
  }
}

