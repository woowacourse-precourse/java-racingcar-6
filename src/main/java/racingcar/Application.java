package racingcar;

import racingcar.controller.RacingController;
import racingcar.domain.dto.CarDTO;
import racingcar.domain.ExceptionCheck;
import java.util.ArrayList;
import java.util.List;

public class Application {

  public static void main(String[] args) {
    RacingController rc = new RacingController();
    ExceptionCheck ec = new ExceptionCheck();


    List<String> carStringList = rc.carStringInputListOutput();
    if(ec.isCarLengthOverCheck(carStringList)){
      throw new IllegalArgumentException();
    }
    List<CarDTO> racingCarList = rc.racingCarList(carStringList);

    int tryCycleChoice = rc.tryCycle();
    rc.racingGameStart(tryCycleChoice,racingCarList);

    List<String> champions = new ArrayList<>();
    rc.selectChampions(champions,racingCarList);

    System.out.println("최종 우승자 : " + String.join(", ",champions));
  } // 메인의 끝
} // 클래스 끝
