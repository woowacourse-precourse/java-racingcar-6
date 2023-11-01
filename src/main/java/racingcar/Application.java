package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.io.IOException;
import java.util.StringTokenizer;

public class Application {
  public static void main(String[] args) throws IOException {

    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    StringTokenizer st = new StringTokenizer(Console.readLine(), ",");

    RacingGame racingGame = RacingGame.getInstance();

    while (st.hasMoreTokens()) {
        String trim = st.nextToken().trim();
        if (trim.length() > 5) {
          throw new IllegalArgumentException();
        }
        racingGame.AddCar(new Car(trim));
    }

    System.out.println("시도할 회수는 몇회인가요?");
    int play_num = Integer.parseInt(Console.readLine());
    System.out.println();

    for (int i = 0; i < play_num; i++) {
      racingGame.play();
    }

    racingGame.result();

  }
}
