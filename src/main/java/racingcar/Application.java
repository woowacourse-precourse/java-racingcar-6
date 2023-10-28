package racingcar;

import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
    }
}

class Game{

    private int moveCount = User.NumberOfMove();
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
    Car() {
        String CarName = readLine();
        for (String name : CarName.split(",")){
            CarInformation.put(name.trim(),"");
        }
        CheckException.CheckRightCarName(CarInformation.keySet());
        CarInformation.forEach((key, value) -> System.out.println("Key: " + key + ", Value: " + value));
    }


    private int CreateRandomNumber() {
        return pickNumberInRange(0,9);
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
