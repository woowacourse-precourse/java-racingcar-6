package racingcar;

import java.util.List;

public class Result {

    CarLocation carLocation = new CarLocation();
    Winner winner = new Winner();

    public void printResult(int turn, List<Car> carList) {

        // 입력한 횟수 만큼 출력하기
        System.out.println("실행 결과");
        for (int i = 0; i < turn; i++) {
            carLocation.carLocate(carList);
            System.out.println();
        }

        // 우승자 출력
        winner.findWinners(carList);

    }
}
