package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;

public class CarNameInput {

    public HashMap<String,Integer> inputCarName() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userAnswer = Console.readLine();

        String[] user = detectErrorInUserInput(userAnswer);

        return arrayToHashMap(user);
    }

    public String[] detectErrorInUserInput(String userAnswer) {

        String[] user = userAnswer.split(",");
        for (String userName : user) {
            if(userName.length()>5){
                throw new IllegalArgumentException();
            }
        }
        return user;
    }

    private HashMap<String,Integer> arrayToHashMap(String[] user){
        HashMap<String, Integer> userResult = new HashMap<>();

        for(String key : user){
            userResult.put(key,0);
        }

        return userResult;
    }

}
