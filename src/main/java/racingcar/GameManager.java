package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Message;
import racingcar.validation.InputException;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    public List<String> inputCarsName(){
//        String[] split = inputStringCarName().split(",");
        ArrayList<String> carName = new ArrayList<>();
        for(String name : this.inputStringCarName()){
            carName.add(name);
        }
        return carName;
    }

    private String[] inputStringCarName() {
        System.out.println(Message.start);
        return InputException.carNameValidation(Console.readLine()).split(",");
    }
//    private int inputNumber(){
//        System.out.println(Message.times);
//        String input = Console.readLine();
//
//    }
}
