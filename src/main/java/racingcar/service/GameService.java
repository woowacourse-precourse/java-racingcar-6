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
  public Car[] car;
  List<Car> winnerList;
  public int tryNum;
  public int forwardNum;
  PrintView printView;


  public GameService(Config config) {
    this.config = config;
    this.maxValue = config.getMaxValue();
    this.minValue = config.getMinValue();
    this.setValue = config.getSetValue();
    winnerList = new ArrayList<Car>();
    printView = new PrintView();
  }



  // 입력값을 받는다.
  public void getInputCar() {
    printView.inputCarNameView();
    String input = Console.readLine();
    splitInputName(input);
  }

  // 입력받은 이름을 나눈다.
  public void splitInputName(String input) {

    String[] splited = input.split(",");
    int carNum = splited.length;

    car = new Car[carNum];

    for(int i=0;i<car.length;i++) {
      Validation.isBlank(splited[i]);
      Validation.isLengthError(splited[i]);
      Validation.isDuplicated(splited[i], car);

      car[i] = new Car(splited[i]);
    }
  }

  public void getInputTryNum() {
    printView.inputTryNumView();
    tryNum = Validation.isNumber(Console.readLine());
  }

  public void carsProcessing() {
    for(int i=0;i<tryNum;i++) {
      carForward();
      printView.carForwardView(car);
      findWinner();
      printView.winnerView(winnerList);
    }
  }


  public void carForward() {
    for(int j=0;j<car.length;j++) {
      forwardNum = RandomUtil.getRandomNumber(minValue, maxValue);
      if(forwardNum >= setValue) {
        car[j].increaseForward();
      }
    }
  }

  public void findWinner() {
    int max= -1;

    for(int i=0;i<car.length;i++) {
      if(car[i].getForward() > max) {
        max = car[i].getForward();
        winnerList.clear();
        winnerList.add(car[i]);
      } else if(car[i].getForward() == max) {
        winnerList.add(car[i]);
      }
    }
  }



}
