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
    String inputCarStringS = Console.readLine();
    List<String> carStringList = cs.StringConvertList(inputCarStringS);

    for(String car : carStringList){
      if(car.length() > 5){
        System.out.println("이름에 대한 예외");
        return;
      }
    }

    List<CarVO> racingCarList = new ArrayList<>();
    for(String name : carStringList){
      CarVO car = new CarVO();
      car.setCar(name);
      racingCarList.add(car);
    }
    System.out.println("시도할 회수는 몇회인가요?");
    String inputCycleString = Console.readLine();
    int tryCycle = cs.StringConvertInt(inputCycleString);

    for (int i = 0; i < tryCycle; i++) {
      for(CarVO car : racingCarList){
        System.out.print(car.getCar() + " : ");

        int randomNumber = Randoms.pickNumberInRange(1,9);
        if(randomNumber > 3){
          car.setMove(1 + car.getMove());
        }
      StringBuilder movePoint = new StringBuilder();
        for (int j = 0; j < car.getMove(); j++) {
          movePoint.append("-");
        }
        System.out.println(movePoint);
      }
      System.out.println();
    }















  }
}
