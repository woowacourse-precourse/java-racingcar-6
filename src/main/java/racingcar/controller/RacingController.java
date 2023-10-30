package racingcar.controller;

import racingcar.domain.ConvertService;
import racingcar.domain.RacingService;
import racingcar.domain.vo.CarVO;
import racingcar.io.InputOutput;
import java.util.List;

public class RacingController {
  private final static InputOutput io = new InputOutput();
  private final static ConvertService cs = new ConvertService();
  private final static RacingService rs = new RacingService();
  public RacingController(){}
  public List<String> carStringInputListOutput(){
    String carStrings = io.startCarInput();
    return cs.StringConvertList(carStrings);
  }
  public int tryCycle(){
    String tryString = io.tryCycleInput();
    return cs.StringConvertInt(tryString);
  }
  public List<CarVO> racingCarList(List<String> carStringList){
    return rs.setCarListName(carStringList);
  }
  public void racingGameStart(int tryCycleChoice,List<CarVO> racingCarList){
    rs.gamePlay(tryCycleChoice,racingCarList);
  }
  public void selectChampions(List<String> champions,List<CarVO> racingCarList){
    rs.selectMaxMove(champions,racingCarList);
  }
}
