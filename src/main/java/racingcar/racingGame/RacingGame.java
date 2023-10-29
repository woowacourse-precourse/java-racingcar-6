package racingcar.racingGame;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {

    private Gamer gamer;
    private List<Car> carList = new ArrayList<>();

    public RacingGame() {
        this.gamer = new Gamer();
    }

    public void gameStart() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<String> carName = gamer.getCarName();

        for(String car : carName) {
            Car newCar = new Car(car);
            this.carList.add(newCar);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNum = gamer.getTryNum();

        raceStart(this.carList, tryNum);
    }

    public void raceStart(List<Car> carList, int tryNum) {

        //입력한 시도 횟수만큼 생성된 각 자동차들이 움직임을 시도함
        for (int i=0; i < tryNum; i++) {
            for (Car car : carList) {
                car.tryMove();

                System.out.println(car.getName() + " : " + car.getDistance());
            }

            System.out.println("---".repeat(20));
        }
    }

}
