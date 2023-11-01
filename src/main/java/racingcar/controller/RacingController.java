package racingcar.controller;

import racingcar.domain.ConvertService;
import racingcar.domain.RacingService;
import racingcar.domain.dto.CarDTO;
import racingcar.domain.InputOutput;
import java.util.List;

public class RacingController {
  private final InputOutput io = new InputOutput();
  private final ConvertService cs = new ConvertService();
  private final RacingService rs = new RacingService();
  public RacingController(){}
  public List<String> carStringInputListOutput(){
    String carStrings = io.startCarInput();
    return cs.StringConvertList(carStrings);
  }
  public int tryCycle(){
    String tryString = io.tryCycleInput();
    return cs.StringConvertInt(tryString);
  }
  public List<CarDTO> racingCarList(List<String> carStringList){
    return rs.setCarListName(carStringList);
  }
  public void racingGameStart(int tryCycleChoice,List<CarDTO> racingCarList){
    rs.gamePlay(tryCycleChoice,racingCarList);
  }
  public void selectChampions(List<String> champions,List<CarDTO> racingCarList){
    rs.selectMaxMove(champions,racingCarList);
  }
}
