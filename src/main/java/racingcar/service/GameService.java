package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
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

  public void carForward() {
    for(int i=0;i<tryNum;i++) {
      for(int j=0;j<car.length;j++) {
        forwardNum = RandomUtil.getRandomNumber(minValue, maxValue);
        if(forwardNum >= setValue) {
          car[j].increaseForward();
        }
      }
    }

    System.out.println("최종결과");
    for(Car c: car) {
      System.out.println(c.getName() + " : " + c.getForward());
    }
  }



}
