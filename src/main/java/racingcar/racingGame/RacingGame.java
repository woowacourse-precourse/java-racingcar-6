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

        for (String car : carName) {
            Car newCar = new Car(car);
            this.carList.add(newCar);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        int tryNum = gamer.getTryNum();

        raceStart(this.carList, tryNum);
        printResult();
    }

    public void raceStart(List<Car> carList, int tryNum) {

        System.out.println("\n실행 결과");
        for (int i = 0; i < tryNum; i++) {
            for (Car car : carList) {
                car.tryMove();
                car.printDistance();
            }
            System.out.println();
        }
    }

    public void printResult() {

        StringBuilder sb = new StringBuilder();

        int winnerDistance = -1;
        List<String> winnerList = new ArrayList<>();

        for (Car car : carList) {
            if (car.getDistance() > winnerDistance) {
                winnerList = new ArrayList<>();
                winnerDistance = car.getDistance();
                winnerList.add(car.getName());
            } else if (car.getDistance() == winnerDistance) {
                winnerList.add(car.getName());
            }
        }

        sb.append("최종 우승자 : ");

        for (int i = 0; i < winnerList.size(); i++) {

            if (i != winnerList.size() - 1) {
                sb.append(winnerList.get(i) + ", ");
            } else {
                sb.append(winnerList.get(i));
            }
        }

        System.out.println(sb.toString());
    }

}
