package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class RacingCar {
    public void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String inputString = Console.readLine(); //사용자로부터 자동차 이름 입력받음
        String[] names = inputString.split(","); //','로 자동차 이름 구분

        List<Car> carList = new ArrayList<>(); //자동차 클래스 배열
        for (String name : names) {
            carList.add(new Car(name));
        }

        System.out.println("시도할 회수는 몇회인가요?");
        inputString = Console.readLine(); //사용자로부터 시도 회수 입력받음
        int attemptNum = Integer.parseInt(inputString);

        System.out.println("\n실행결과");
        for (int i = 0; i < attemptNum; i++) {
            randomMove(carList);
            System.out.println();
        } //실행 결과 출력

        FindWinner findWinner = new FindWinner(carList); //우승자 선정을 위한 클래스

        findWinner.printWinner(); //우승자 출력
    }
    void randomMove(List<Car> carList) {
        for (Car car : carList) {
            TrafficController trafficController = new TrafficController();
            if (trafficController.isMoveForward()) {
                car.moveForward();
            }
            car.showPosition();
        }
    }
}
