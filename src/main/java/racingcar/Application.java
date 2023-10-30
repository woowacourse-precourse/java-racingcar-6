package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.controller.RacingController;
import racingcar.domain.ConvertService;
import racingcar.domain.vo.CarVO;
import racingcar.io.ExceptionCheck;

import java.util.ArrayList;
import java.util.List;

public class Application {
  private final static RacingController rc = new RacingController();
  private final static ExceptionCheck ec = new ExceptionCheck();
  public static void main(String[] args) {
    List<String> carStringList = rc.carStringInputListOutput();
    if(ec.isCarLengthOverCheck(carStringList)){
      throw new IllegalArgumentException();
    }
    List<CarVO> racingCarList = rc.racingCarList(carStringList);

    int tryCycleChoice = rc.tryCycle();
    rc.racingGameStart(tryCycleChoice,racingCarList);

    List<String> champions = new ArrayList<>();
    //변화 포인트
    rc.selectChampions(champions,racingCarList);

    System.out.println("최종 우승자 : " + String.join(", ",champions));
  } // 메인의 끝
} // 클래스 끝
