package racingcar.view;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import racingcar.message.OutputMessage;
import racingcar.model.Car;

public class OutputView {

    List<String> winners = new ArrayList<>();

    public void round(List<Car> cars){

        for(Car car : cars){
            System.out.print(car.getName() + " : ");
            System.out.print("-".repeat(car.getPosition()));
            System.out.println();
        }
        System.out.println();
    }

    public void winnerResult(List<Car> cars, int finalPrize){
        printMessage(OutputMessage.FINAL_WINNER);
        for(Car car : cars){
            if(car.getPosition() == finalPrize) winners.add(car.getName());
        }

        useStringJoiner();
    }

    public void useStringJoiner(){
        StringJoiner joiner = new StringJoiner(", ");
        for(String winner : winners) joiner.add(winner);
        System.out.println(joiner);
    }

    private void printMessage(String text) {
        System.out.print(text);
    }
}
