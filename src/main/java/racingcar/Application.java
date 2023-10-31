package racingcar;

import racingcar.domain.Car;
import racingcar.game.Race;

import java.util.ArrayList;
import java.util.List;

import static racingcar.view.InputView.askCarNames;
import static racingcar.view.InputView.askRunningCnt;


public class Application {
    public static void main(String[] args) {

        String [] name = askCarNames().split(",");
        List<String> nameList = List.of(name);
        List<Car> carList = new ArrayList<>();

        for (String s : nameList) {
            carList.add(new Car(s));
        }

        int trial = askRunningCnt();

        Race racingGame = new Race(carList,trial);




//        int max = Integer.MIN_VALUE;;
//
//        for(int i = 0; i<cars.length;i++){
//            max = Math.max(max,cars[i].getPosition());
//        }
//
//        for(int j = 0; j<cars.length;j++){
//            if(cars[j].getPosition() == max){
//                System.out.println("최종 우승자 : " + cars[j].getName());
//            }
//        }
//



    }
}
