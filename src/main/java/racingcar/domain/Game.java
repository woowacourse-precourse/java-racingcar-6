package racingcar.domain;

import java.util.List;

public class Game {
    List<Car> cars;
    int totalRounds;
    RaceDecisionMaker decision;

    public Game(List<Car> cars, int totalRounds) {
        this.cars = cars;
        this.totalRounds = totalRounds;
        // 아래는 인자를 제대로 받아왔는지 확인하는 코드
        /*
        for (Car car : cars) {
            System.out.println("car : " + car.name);
        }*/
    }

    public void play() {
        System.out.println("\n실행 결과");
        for (int i = 0; i < totalRounds; ++i) {
            driveCars();
            printCars();
        }
        gameEnd();
    }
    void gameEnd() {
        String winners = "최종 우승자 : ";
        winners += WinnerDeterminer.winner(cars);
        System.out.print(winners);
    }
    void driveCars() {
        decision = new RaceDecisionMaker();
        for (Car car : cars) {
            boolean go = decision.raceDecision();
            car.move(go);
        }
    }
    void printCars() {
        for (Car car : cars) {
            printCar(car);
        }
        System.out.print("\n");
    }
    // 해당 차의 이동현황을 출력
    void printCar(Car car) {
        String printString = car.name + " : ";
        printString += "-".repeat(car.position);
        System.out.println(printString);
    }

}
