package racingcar.view;


import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public void printResultMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public void printRoundResult(List<Car> carList) {
        carList.forEach(car -> {
            System.out.println(car.getName() + " : " + car.getStatusBar());
        });
    }

    public void printWinner() {
        System.out.println("최종 우승자: ");
    }
}
