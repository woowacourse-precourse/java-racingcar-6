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
        printResult();
    }

    public void raceStart(List<Car> carList, int tryNum) {

        System.out.println("\n실행 결과");
        for (int i=0; i < tryNum; i++) {
            for (Car car : carList) {
                car.tryMove();
                car.printDistance();
            }
            System.out.println();
        }
    }

    public void printResult() {

        int winnerDistance = -1;
        List<String> winnerList = new ArrayList<>();

        for(Car car : carList) {

            if(car.getDistance() > winnerDistance) {
                //신기록 갱신시 리스트를 다시만들고 신기록 세운 자동차만 저장
                winnerList = new ArrayList<>();
                winnerDistance = car.getDistance();
                winnerList.add(car.getName());
            } else if(car.getDistance() == winnerDistance) {
                //같은 거리의 자동차가 발견되면 리스트에 해당 자동차를 추가
                winnerList.add(car.getName());
            }
        }

        System.out.print("최종 우승자 : ");
        for(String winner : winnerList) {
            System.out.print(winner + ", ");
        }

    }

}
