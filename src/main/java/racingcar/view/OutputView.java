package racingcar.view;

import java.util.List;
import racingcar.controller.GameController;
import racingcar.message.OutputMessage;
import racingcar.model.Car;

public class OutputView {

    public void round(List<Car> cars){

        for(Car car : cars){
//            printMessage(car.getName() + " : ");
//            printMessage("-".repeat(car.getPosition()));
//            System.out.println();
            System.out.print(car.getName() + " : ");
            System.out.print("-".repeat(car.getPosition()));
            System.out.println();
        }
        System.out.println();

    }

    private void printMessage(String text) {
        System.out.print(text);
    }
}
