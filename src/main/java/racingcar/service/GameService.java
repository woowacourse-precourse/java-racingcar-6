package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.config.Config;
import racingcar.model.Car;
import racingcar.utils.RandomUtil;
import racingcar.utils.Validation;

public class GameService {

  private Config config;
  private int minValue;
  private int maxValue;
  private int setValue;
  public Car[] car;
  List<Car> winnerList;
  public int tryNum;
  public int forwardNum;


  public GameService(Config config) {
    this.config = config;
    this.maxValue = config.getMaxValue();
    this.minValue = config.getMinValue();
    this.setValue = config.getSetValue();
  }



  // 입력값을 받는다.
  public void getInputCar() {
    System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
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
    System.out.println("시도할 횟수는 몇회인가요?");
    tryNum = Validation.isNumber(Console.readLine());
  }

  public void carsProcessing() {
    for(int i=0;i<tryNum;i++) {
      carForward();
      carForwardView();
      findWinner();
      winnerView();
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

  public void carForwardView() {
    System.out.println("실행 결과");
    for(int i=0;i<car.length;i++) {
      System.out.print(car[i].getName() + " : ");
      for(int k=0;k<car[i].getForward();k++)
        System.out.print("-");
    }
    System.out.println();
  }

  public void findWinner() {
    winnerList = new ArrayList<Car>();
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

  public void winnerView() {
    System.out.print("최종 우승자 : ");
    for (int i = 0; i < winnerList.size(); i++) {
      Car winner = winnerList.get(i);
      System.out.print(winner.getName());

      if (i < winnerList.size() - 1) {
        System.out.print(", ");
      }
    }
  }


}
