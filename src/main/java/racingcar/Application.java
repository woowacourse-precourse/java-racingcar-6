package racingcar;

public class Application {
  static HostReception host = new HostReception();

  static int round;

  public static void main(String[] args) {
    // TODO: 프로그램 구현
    host.getParticipant();
    round = host.getRoundFromUser();

    while (round-- > 0) {
      host.proceedARound();
      System.out.println();
    }

    host.announceWinner();
  }
}
