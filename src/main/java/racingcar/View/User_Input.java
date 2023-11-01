package racingcar.View;
import camp.nextstep.edu.missionutils.Console;
import racingcar.ConstantAndGameLogic.Message;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class User_Input {
    public List<String> InputName(){
        String userInput = Console.readLine();
        checkNameSpace(userInput);
        checkNameLength(userInput);
        checkSameName(userInput);
        checkCommaInput(userInput);
        String[] inputCars = userInput.split(",");
        return Arrays.stream(inputCars).collect(Collectors.toList());
    }
    public void checkCommaInput(String userInput) {
        if (userInput.endsWith(",")) { // 콤마로 이름을 구분짓지 않으면 예외 발생
            throw new IllegalArgumentException(Message.CAR_NAME_COMMA);
        }
    }

    public void checkNameLength(String userInput){
        String[] user = userInput.split(",");
        for (String carname : user){
            if (5 < carname.length()){
                throw new IllegalArgumentException(Message.CAR_NAME_LENGTH);
            }
        }
    }
    public void checkNameSpace(String userInput){
        String[] user = userInput.split(",");
        for (String carname : user){
            if (carname.isEmpty()){
                throw new IllegalArgumentException(Message.NAME_SPACE);
            }
        }
    }

    public  void checkSameName(String userInput){
        String[] user = userInput.split(",");
        Set<String> name = new HashSet<>();
        for (String carname : user){
            if (!name.add(carname)){
                throw new IllegalArgumentException(Message.SAME_NAME);
            }
        }
    }
    public int UserCountInput(){
        String UserNumber = Console.readLine();
        checkCountInput(UserNumber);
        int usernumber = Integer.parseInt(UserNumber);
        return usernumber;
    }
    public void checkCountInput(String UserNumber){
        try {
            Integer.parseInt(UserNumber);
        }catch (IllegalArgumentException e){
            throw new IllegalArgumentException(Message.MUST_INPUT_NUMBER);
        }
    }
}