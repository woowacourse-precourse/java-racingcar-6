package racingcar.controller;

import racingcar.domain.ConvertService;
import racingcar.io.InputOutput;

import java.util.List;

public class RacingController {
  private final static InputOutput io = new InputOutput();
  private final static ConvertService cs = new ConvertService();
  public RacingController(){}

  public List<String> carStringInputListOutput(){
    String carStrings = io.startCarInput();
    return cs.StringConvertList(carStrings);
  }






}
