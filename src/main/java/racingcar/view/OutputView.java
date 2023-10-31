package racingcar.view;

public class OutputView {
  public void printCarStatus(String name, int position) {
    System.out.println(name + ": " + new String(new char[position]).replace("\0", "-"));
  }

  public void printWinners(String winners) {
    System.out.println("최종 우승자 : " + winners);
  }
}
