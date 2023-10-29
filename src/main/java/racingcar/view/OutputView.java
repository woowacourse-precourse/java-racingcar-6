package racingcar.view;

import java.util.List;
import racingcar.controller.GameController;
import racingcar.message.OutputMessage;
import racingcar.model.Car;

public class OutputView {

    public void round(List<Car> cars){

        for(Car car : cars){
            System.out.print(car.getName() + " : ");
            System.out.print("-".repeat(car.getPosition()));
            System.out.println();
        }
        System.out.println();
    }

    public void winnerResult(List<Car> cars, int finalPrize){
        System.out.println("최종 우승자 : ");
        int count = 0;
        for(int i = 0; i < cars.size(); i++){
            if(cars.get(i).getPosition() == finalPrize){
                if(count == 0) System.out.print(cars.get(i).getName());
                else System.out.print(", " + cars.get(i).getName());
            }
        }
    }

    private void printMessage(String text) {
        System.out.print(text);
    }
}
