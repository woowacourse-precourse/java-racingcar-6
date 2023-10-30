package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.vo.CarVO;

import java.util.ArrayList;
import java.util.List;

public class RacingService {

  public RacingService() {}

  public List<CarVO> setCarListName(List<String> carList){
    List<CarVO> list = new ArrayList<>();
    for(String name : carList){
      CarVO car = new CarVO();
      car.setCar(name);
      list.add(car);
    }
    return list;
  }
  public void gamePlay(int tryCycleChoice,List<CarVO> racingCarList){
    for (int i = 0; i < tryCycleChoice; i++) {
      for(CarVO car : racingCarList){
        int randomNumber = Randoms.pickNumberInRange(1,9);
        if(randomNumber > 3){
          car.setMove(1 + car.getMove());
        }
        StringBuilder movePoint = new StringBuilder();
        for (int j = 0; j < car.getMove(); j++) {
          movePoint.append("-");
        }
        System.out.print(car.getCar() + " : ");
        System.out.println(movePoint);

        car.setCar(car.getCar());
      }
      System.out.println();
    }
  }

}
