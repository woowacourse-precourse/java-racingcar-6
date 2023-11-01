package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;
import racingcar.constants.Message;

public class GameView {
    public String readCarNames(){
        System.out.println(Message.READ_CAR_NAME);
        return Console.readLine();
    }

    public String readNumberOfMoves() {
        System.out.println(Message.READ_NUMBER_OF_MOVES);
        return Console.readLine();
    }

    private void printPositions(List<Car> cars, int index){
        for(Car car : cars){
            System.out.println(
                    car.getName() + " : " + "-".repeat(car.getPosition(index))
            );
        }
        System.out.println();
    }

    public void printResult(List<Car> cars, int numberOfMoves) {
        System.out.println(Message.PRINT_RESULT);
        for(int i=1;i<=numberOfMoves;i++){
            printPositions(cars, i);
        }
    }

    public void printWinners(List<Car> winners){
        System.out.print(Message.PRINT_WINNER);
        System.out.println(String.join(",", winners.stream()
                .map(Car::getName)
                .toList()));
    }
}
