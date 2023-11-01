package racingcar;

import java.util.ArrayList;

public class RaceManagement {
    ArrayList<Car> CarArray = new ArrayList<>();
    int moveNumber;

    public RaceManagement(ArrayList<String> carNameArray, int inputMoveNumber){
        for (String carName : carNameArray){
            CarArray.add(new Car(carName));
        }
        this.moveNumber = inputMoveNumber;
    }





    public void moveAllRound(){
        System.out.print("실행 결과\n");
        for (int moveIndex = 1; moveIndex <= moveNumber; moveIndex++) {
            moveOneRound();
            printCurrentStatus();
            System.out.print("\n");
        }

        printFinalWinner();

    }

    public void moveOneRound(){
        for(Car car : CarArray){
            car.move();
        }

    }

    public void printCurrentStatus(){
        for(Car car : CarArray){
            System.out.print(car.name + " : ");
            for (int carNum = 1; carNum <= car.location; carNum++) {
                System.out.print("-");
            }
            System.out.print("\n");
        }
    }

    public void printFinalWinner(){
        int maxLocation = 0;
        for(Car car : CarArray){
            if(car.location > maxLocation){
                maxLocation = car.location;
            }
        }

        String winnner = "최종 우승자 : ";
        for(Car car : CarArray){
            if(car.location == maxLocation){
                winnner += car.name;
                winnner += ", ";
            }
        }
        String result = winnner.substring(0, winnner.length() - 2); //마지막 쉼표 공백 제거
        System.out.print(result);
    }

}
