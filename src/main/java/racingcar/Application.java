package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
  public static void main(String[] args) {
    List<String> carNames = getCarNamesFromUser();
    int rounds = getRoundsFromUser();
    
    RacingGame racingGame = new RacingGame(carNames, rounds);
    racingGame.race();
    
    System.out.print("죄종 우승자 : " + String.join(", ", racingGame.getWinners()));
  }
  
  private static List<String> getCarNamesFromUser() {
    System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    return Arrays.stream(input.split(","))
            .map(String::trim)
            .collect(Collectors.toList());
  }
  
  private static int getRoundsFromUser() {
    System.out.println("시도할 회수는 몇회인가요?");
    return Integer.parseInt(Console.readLine());
  }
}