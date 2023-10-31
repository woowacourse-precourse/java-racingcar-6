package views;// src/main/java/ConsoleView.java
import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import models.Car;

public class ConsoleView {
    private final Console console;

    public ConsoleView(Console console) {
        this.console = console;
    }

    public void displayGameState(List<Car> cars) {
        for (Car car : cars) {
            console.print(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        console.println();
    }

    public void displayWinners(List<String> winners) {
        console.print("최종 우승자: ");
        console.println(String.join(", ", winners));
    }
}
