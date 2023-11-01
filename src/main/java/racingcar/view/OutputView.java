package racingcar.view;

import java.util.List;

public class OutputView {
  public void printCarStatus(String name, int position) {
    System.out.println(name + ": " + new String(new char[position]).replace("\0", "-"));
  }

  public void printWinners(List<String> winners) {
    System.out.println("최종 우승자 : " + winners);
  }
}
