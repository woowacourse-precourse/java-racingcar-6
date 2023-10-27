package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class GameManager {

    List<Car> carList;

    public void gamePlay() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carNameList = UserInputReceiver.receiveCarNameAndGetCarNameList(Console.readLine());
        carList = CarFactory.createCars(carNameList);

        System.out.println("시도할 회수는 몇회인가요?");

        int tryTimes = UserInputReceiver.receiveTryTimes(Console.readLine());

        startForward(carList, tryTimes);
    }

    public void startForward(List<Car> cars,int tryTimes) {

        for (int i = 0; i < tryTimes; i++) {

            cars.forEach(car->car.tryForwardByCondition(Randoms.pickNumberInRange(0,9)));

        }

    }

}
