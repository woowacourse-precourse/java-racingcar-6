package racingcar.view;

import racingcar.model.Car;
import racingcar.model.Cars;
import racingcar.util.Message;

import java.util.List;

public class Output {

    public static void printGap(){
        System.out.println();
    }
    public static void printMessage(Message message){
        System.out.println(message);
    }
    public static void printGameResult(Cars cars){
        List<Car> carList = cars.getCars();

        for(int i = 0; i< carList.size();i++){
            Car car = carList.get(i);
            System.out.println(car.getCarName() + " : " + car.getDistance());
        }

        System.out.println();
    }
    public static void printGameWinners(Message message, List<String>winners){
        System.out.println(message + " : " + String.join(", ",winners));
    }
}
