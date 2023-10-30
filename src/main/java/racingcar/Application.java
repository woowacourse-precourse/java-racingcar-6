package racingcar;


import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.ConvertService;
import racingcar.domain.vo.CarVO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {

  private final static ConvertService cs = new ConvertService();
  public static void main(String[] args) {

    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    String tryRacingInput = Console.readLine();
    List<String> inputList = cs.StringConvertList(tryRacingInput);

    for(String car : inputList){
      if(car.length() > 5){
        System.out.println("이름에 대한 예외");
        return;
      }
    }

    System.out.println("시도할 회수는 몇회인가요?");
    String tryCycle = Console.readLine();
    int num = cs.StringConvertInt(tryCycle);










  }
}
