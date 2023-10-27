package view;

import static constant.ConstantString.FINAL_WINNER;

import constant.ConstantString;
import domain.Car;
import java.util.ArrayList;
import java.util.List;

public class OutputView {
    private OutputView() {
    }

    public static void printProcess(List<Car> carsList) {
        carsList.forEach(car -> {
            String process = ConstantString.processMessage(car);
            System.out.println(process);
        });
        System.out.println();
    }

    public static void printWinners(List<String> winnerLists) {
        System.out.print(FINAL_WINNER);
        String winners = String.join(", ", winnerLists);
        System.out.println(winners);
    }
}
