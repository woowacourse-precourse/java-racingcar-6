package racingcar.domain;

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

}
