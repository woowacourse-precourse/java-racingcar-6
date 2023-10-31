package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingCarGame {
    public void playGame(){

        String[] carNames = InputHandler.carNameInput();
        int targetNumber = InputHandler.targetNumberInput();

        int carCount = carNames.length;
        Car[] cars = new Car[carCount];
        for(int i = 0; i < carCount; i++){
            cars[i] = new Car(carNames[i]);
        }

        int tryNumber = 0;

        System.out.println("실행결과");
        while(tryNumber < targetNumber){
            for (Car car:cars){
                car.move();
                printBoard(car);
            }
            System.out.println();
            tryNumber++;
        }

        int maxValue = findMaxValue(cars);

        int winnerCheck = 0;

        List<String> printList = new ArrayList<>();
        System.out.print("최종 우승자 : ");
        for(Car car:cars){
            if(car.getPosition() == maxValue){
                printList.add(car.getName());
            }
        }
        System.out.println(String.join(", ",printList));
    }

    public void printBoard(Car car){
        System.out.print(car.getName() + " : ");
        for(int i = 0; i < car.getPosition(); i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public int findMaxValue(Car[] cars){
        int maxVaule = 0;

        for (Car car:cars){
            if(maxVaule<car.getPosition()){
                maxVaule = car.getPosition();
            }
        }

        return maxVaule;

    }
}
