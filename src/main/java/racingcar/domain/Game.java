package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public void start() {
        List<Car> carList = makeCar();
        int numberOfAttempts = getNumberOfAttempts();
        System.out.println("실행 결과");
        for (int count = 0; count < numberOfAttempts; count++) {
            play(carList);
            showResult(carList);
        }
        showWinner(carList);
    }

    private List<Car> makeCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        CarName carName = new CarName(Console.readLine());
        List<String> carNameList = carName.getCarNameStrList();
        List<Car> carList = new ArrayList<>();
        for (int idx = 0; idx < carNameList.size(); idx++) {
            Car car = new Car(carNameList.get(idx));
            carList.add(car);
        }
        return carList;
    }

    private int getNumberOfAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
        Attempt attemp = new Attempt(Console.readLine());
        System.out.println();
        return attemp.getNumber();
    }

    private void play(List<Car> carList) {
        for (Car car : carList) {
            car.move(Randoms.pickNumberInRange(0,9));
        }

    }

    private void showResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getName()+" : ");
            System.out.println(car.getPosition());
        }
        System.out.println();
    }
//
//    private String carPosition(int position) {
//        String positionStr = "";
//        for (int count = 0; count < position; count++) {
//            positionStr += "-";
//        }
//        return positionStr;
//    }

    private void showWinner(List<Car> carList) {
        //sort 후 출
    }
}
