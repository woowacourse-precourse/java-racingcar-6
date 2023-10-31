package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static racingcar.domain.Ask.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Determine;
import racingcar.domain.Print;

public class Application {
  public static void main(String[] args) {
    List<String> carNames = askCarNames();
    List<String> go = new ArrayList<>();
    String result = "";
    for (int i = 0; i < carNames.size(); i++) {
      go.add("");
    }

    int attempt = askAttemptsOfNum();
    System.out.println();
    System.out.println("실행 결과");
    for (int i = 0; i < attempt; i++) {
      result = Print.printExecute(carNames, go);
      System.out.println(result);
    }

    System.out.println(Determine.winner(go, carNames));
    Console.close();
  }


}
