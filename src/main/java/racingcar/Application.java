package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
    }
}

class User{
    private int NumberOfMove(){
         String InputTry = readLine();
         int moveCount = CheckException.CheckRightNumberOfMove(InputTry);
         return moveCount;
    }
}

class Car{
    List<String> CarNameList = new ArrayList<>();
    Car() {
        String CarName = readLine();
        for (String name : CarName.split(",")){
            CarNameList.add(name.trim());
        }
        CheckException.CheckRightCarName(CarNameList);
    }


    private int CreateRandomNumber() {
        return pickNumberInRange(0,9);
    }
}

class CheckException {
    static void CheckRightCarName(List<String> CarNameList){
        for (String name : CarNameList){
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

