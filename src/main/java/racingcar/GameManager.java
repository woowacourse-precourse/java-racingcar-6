package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Message;
import racingcar.validation.InputException;

import java.util.ArrayList;
import java.util.List;

public class GameManager {

    public List<String> inputCarsName(){
        ArrayList<String> carName = new ArrayList<>();
        for(String name : this.inputStringCarName()){
            carName.add(name);
        }
        return carName;
    }

    public String[] inputStringCarName() {
        System.out.println(Message.start);
        return InputException.carNameValidation(Console.readLine()).split(",");
    }
    public int inputNumber(){
        System.out.println(Message.times);
        String input = Console.readLine();
        InputException.numberValidation(input);
        return Integer.parseInt(input);
    }
//    public void winner(List<String> winner){
//        System.out.print(Message.winner);
//        System.out.println(Ra);
//    }

}
