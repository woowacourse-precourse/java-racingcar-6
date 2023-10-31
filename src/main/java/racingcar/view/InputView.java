package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;
import java.util.Set;

public class InputView {

  public String[] getCarNames(){
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String inputName = Console.readLine();
    String[] carNames = inputName.split(",");
    Set<String> uniqueNames = new HashSet<>();
    for(String name: carNames){
      if(name.trim().isEmpty() || name.trim().length()>5){
        throw new IllegalArgumentException("자동차 이름은 1글자 이상, 5글자 이하여야 한다.");
      }
      if(!uniqueNames.add(name.trim())){
        throw new IllegalArgumentException("중복된 자동차 이름이 있으면 안 된다.");
      }
    }
    return carNames;
  }
}
