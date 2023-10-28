package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Game {
    public void start() {
        /**
         * 1. 차 객체 만들기
         * 2. 시도 횟수 입력 받기
         * 3. 실행
         * 4. 실행 결과 표시
         */
        List<Car> carList = makeCar();
        int numberOfAttempts = getNumberOfAttempts();
        System.out.println("실행 결과");
        for (int count = 0; count < numberOfAttempts; count++) {
            play(carList);
            showResult(carList);
        }

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
        Attemp attemp = new Attemp(Console.readLine());
        System.out.println();
        return attemp.getNumber();
    }

    private void play(List<Car> carList) {
        for (Car car : carList) {
            car.move();
        }

    }

    private void showResult(List<Car> carList) {
        for (Car car : carList) {
            System.out.print(car.getCarName()+" : ");
            System.out.println(carPosition(car.getCarPosition()));
        }
        System.out.println();
    }

    private String carPosition(int position) {
        String positionStr = "";
        for (int count = 0; count < position; count++) {
            positionStr += "-";
        }
        return positionStr;
    }
}
