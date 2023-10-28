package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        car.displayCarInformation();

    }
}
class User{
    static int NumberOfMove(){
        String InputTry = readLine();
        int moveCount = CheckException.CheckRightNumberOfMove(InputTry);
        return moveCount;
    }
}

class Car{
    Map<String,String> CarInformation = new HashMap<>();
    int RepeatCount;
    public Car() {
        init();
    }
    public void init(){
        String CarName = readLine();
        for (String name : CarName.split(",")){
            CarInformation.put(name.trim(),"");
        }
        CheckException.CheckRightCarName(CarInformation.keySet());
        RepeatCount = User.NumberOfMove();
        this.WhichCarWillMove(CarInformation.keySet());
    }
    private int CreateRandomNumber() {
        return pickNumberInRange(0,9);
    }
    private boolean CheckGoOrStop(int num){
        if (num >= 4){
            return true;
        }
        return false;
    }
    private void WriteForwardDistance(String CarName){
        String distance ="";
        for (int i=0; i<RepeatCount; i++){
            int num = CreateRandomNumber();
            if (CheckGoOrStop(num)){
                distance += "-";
                CarInformation.put(CarName,distance);
            }
        }
    }

    private void WhichCarWillMove(Set<String> CarNameSet){
        for (String CarName : CarNameSet){
            WriteForwardDistance(CarName);
        }
    }
    public void displayCarInformation() {
        CarInformation.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }
}

class CheckException {
    static void CheckRightCarName(Set<String> CarNameSet){
        for (String name : CarNameSet){
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    static int CheckRightNumberOfMove(String move){
        try{
            int number = Integer.parseInt(move);
            return number;
        }
        catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
}