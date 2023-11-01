package racingcar.view;


import java.util.List;
import java.util.stream.Collectors;
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
        System.out.println();
    }

    public void printWinner(List<Car> winnerList) {
        System.out.print("최종 우승자 : ");
        System.out.println(winnerList.stream().map(Car::getName).collect(Collectors.joining(", ")));
    }
}
