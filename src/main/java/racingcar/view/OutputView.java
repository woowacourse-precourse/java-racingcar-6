package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public void showResult() {
        System.out.println("\n실행 결과");
    }

    public void showRoundResult(List<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            Car car = carList.get(i);
            String name = car.getName();
            int move = car.getTotalMove();
            System.out.print(name + " : ");
            moveBar(move);
            System.out.print("\n");
        }
        System.out.print("\n");
    }

    private void moveBar(int move) {
        for (int i = 0; i < move; i++) {
            System.out.print("-");
        }
    }

    public void showWinner(List<String> winnerList) {
        String result = String.join(", ", winnerList);
        System.out.print("최종 우승자 : " + result);
    }
}
