package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class UserInput {
  
  public static List<String> getCarNamesFromUser() {
    System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    return Arrays.stream(input.split(","))
        .map(String::trim)
        .collect(Collectors.toList());
  }
  
  public static int getRoundsFromUser() {
    System.out.println("시도할 회수는 몇회인가요?");
    return Integer.parseInt(Console.readLine());
  }
}
