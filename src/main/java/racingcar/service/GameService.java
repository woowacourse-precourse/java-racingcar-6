package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.utils.Validation;

public class GameService {
  public Car[] car;
  public int tryNum;
  Validation validation = new Validation();


  public void startGame() {
    getInputCar();
    getInputTryNum();
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
      validation.isBlank(splited[i]);
      validation.isLengthError(splited[i]);
      validation.isDuplicated(splited[i], car);

      car[i] = new Car(splited[i]);
    }
  }

  public void getInputTryNum() {
    System.out.println("시도할 횟수는 몇회인가요?");
    tryNum = validation.isNumber(Console.readLine());
  }

}
