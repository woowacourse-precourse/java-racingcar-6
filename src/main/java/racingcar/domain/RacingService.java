package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.dto.CarDTO;
import java.util.ArrayList;
import java.util.List;

public class RacingService {
  public RacingService() {}
  public List<CarDTO> setCarListName(List<String> carList){
    List<CarDTO> list = new ArrayList<>();
    for(String name : carList){
      CarDTO car = new CarDTO();
      car.setCar(name);
      list.add(car);
    }
    return list;
  }
  public void gamePlay(int tryCycleChoice,List<CarDTO> racingCarList){
    for (int i = 0; i < tryCycleChoice; i++) {
      for(CarDTO car : racingCarList){
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
  public void selectMaxMove(List<String> champions,List<CarDTO> racingCarList){
    int maxMove = -1;
    for (CarDTO car : racingCarList){
      if (car.getMove() > maxMove){
        maxMove = car.getMove();
      }
    }
    for (CarDTO car : racingCarList){
      if (car.getMove() == maxMove){
        champions.add(car.getCar());
      }
    }
  }
}
