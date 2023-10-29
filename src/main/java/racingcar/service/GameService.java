package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.config.Config;
import racingcar.model.Car;
import racingcar.utils.RandomUtil;
import racingcar.utils.Validation;
import racingcar.view.PrintView;

public class GameService {

  private Config config;
  private int minValue;
  private int maxValue;
  private int setValue;
  public List<Car> carList;
  public List<Car> winnerList;
  public int tryNum;
  public int forwardNum;



  public GameService(Config config) {
    this.config = config;
    this.maxValue = config.getMaxValue();
    this.minValue = config.getMinValue();
    this.setValue = config.getSetValue();
    winnerList = new ArrayList<Car>();
    carList = new ArrayList<Car>();
  }



  // 입력값을 받는다.
  public void getInputCar() {
    String input = Console.readLine();
    splitInputName(input);
  }

  // 입력받은 이름을 나눈다.
  public void splitInputName(String input) {

    String[] splited = input.split(",");
    int carNum = splited.length;


    for(int i=0;i<carNum;i++) {
      Validation.isBlank(splited[i]);
      Validation.isLengthError(splited[i]);
      Validation.isDuplicated(splited[i], carList);

      carList.add(new Car(splited[i]));
    }
  }

  public void getInputTryNum() {
    tryNum = Validation.isNumber(Console.readLine());
  }


  public void carForward() {
    for(int j=0;j<carList.size();j++) {
      forwardNum = RandomUtil.getRandomNumber(minValue, maxValue);
      if(forwardNum >= setValue) {
        carList.get(j).increaseForward();
      }
    }
  }

  public void findWinner() {
    int max= -1;

    for(int i=0;i< carList.size();i++) {
      if(carList.get(i).getForward() > max) {
        max = carList.get(i).getForward();
        winnerList.clear();
        winnerList.add(carList.get(i));
      } else if(carList.get(i).getForward() == max) {
        winnerList.add(carList.get(i));
      }
    }
  }



}
