package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.view.console.ConsoleWriter;

import java.util.List;

public class OutputView {
    ConsoleWriter consoleWriter = new ConsoleWriter();


    public void printCarPosition(List<Car> cars){
        for(Car car : cars) {
            consoleWriter.printMessage(car.getName() + " : " + car.getPosition());
            consoleWriter.printMessage("");

        }
    }

    public void printWinner(List<Car> cars){
        StringBuilder winner = new StringBuilder();
        for(Car car : cars){
            winner.append(car.getName()).append(", ");
        }
        winner.setLength(winner.length() - 2);
        consoleWriter.printMessage("최종 우승자 : " + winner.toString());
    }
}
