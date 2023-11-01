package racingcar.View;

import racingcar.ConstantAndGameLogic.Message;
import racingcar.Model.Car;

import java.util.List;

public class Output {

    public void inputName(){
        System.out.println(Message.USER_INPUT_CAR_NAME);
    }

    public void inputNumber(){
        System.out.println(Message.USER_INPUT_MOVE_COUNT);
    }
    public void printCars(List<Car> cars){
        for (Car car : cars){
            System.out.println(car.getCarName()+" : "+Moving(car.getCurrentLocation()));
        }
        System.out.println();
    }

    public void printRaceStart(){
        System.out.println(Message.FINISH_GAME);
    }

    public String Moving(int CurrentLocation){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < CurrentLocation; i++){
            stringBuilder.append("-");
        }
        return stringBuilder.toString();
    }

        public void printWinners(List<String> winners){
        String winnersName = String.join(", ",winners);
        System.out.println(Message.FINAL_WINNER+winnersName);
    }
}