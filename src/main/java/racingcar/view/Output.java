package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class Output {
    private static final String PRINT_RESULT_MESSAGE = "실행 결과";
    private static final String PRINT_FINAL_WINNER_MESSAGE = "최종 우승자 : ";

    public void printResultMessage() {
        System.out.println(System.lineSeparator() + PRINT_RESULT_MESSAGE);
    }

    public void printCurrentCar(List<Car> carList) {
        carList.forEach(car -> {
            System.out.print(car.getCarName() + " : ");
            System.out.println("-".repeat(car.getCount()));
        });
        System.out.println();
    }
    
    public void printFinalWinner(List<String> winnerName) {
        System.out.print(PRINT_FINAL_WINNER_MESSAGE + String.join(", ", winnerName));
    }

}
