package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class CarName {
  public List<String> Car() {

    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String input = Console.readLine();
    List<String> Car_name = new ArrayList<>();

    String[] nameArray = input.split(",");
    for (String name : nameArray) {
      Car_name.add(name.trim());

    }
    exception_length(input);
    return Car_name;

  }
  
  public void exception_length(String s) {
    if(s.length() > 5) {
      throw new IllegalArgumentException("5자 이하로 입력하세요.");
    }
  }
}
