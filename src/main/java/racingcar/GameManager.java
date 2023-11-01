package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Message;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    public List<String> inputCarsName(){
        String[] split = inputStringCarName().split(",");
        ArrayList<String> carName = new ArrayList<>();
        for(String name : split){
            carName.add(name);
        }
        return carName;
    }

    private String inputStringCarName() {
        System.out.println(Message.start);
        String str = Console.readLine();
        return str;
    }
}
