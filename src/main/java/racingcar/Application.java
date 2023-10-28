package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

    }
}

class Game{

}

class User{

}

class Car{

    static void CreateCarName() {
        String CarName = readLine();
        List<String> CarNameList = new ArrayList<>();

        for (String name : CarName.split(",")){
            CarNameList.add(name.trim());
        }
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
}

