package view;

import constant.ConstantString;
import domain.Car;
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
}
