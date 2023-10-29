package racingcar;

import java.util.ArrayList;
import java.util.List;

public class GameSimulation {


    public GameSimulation(){
    }

    public List<String> userInit(String userInput){
        String[] array = userInput.split(",");
        List<String> userList = new ArrayList<>();
        for (int i = 0; i < array.length; i++){
            if (array[i].contains(" ")){
                throw new IllegalArgumentException("이름에 공백이 있으면 안됩니다.");
            }
            if (array[i].length()>5){
                throw new IllegalArgumentException("이름이 5자리 이상입니다.");
            }
            if (userList.contains(array[i])){
                throw new IllegalArgumentException("같은 이름이 존재합니다.");
            }
            userList.add(array[i]);
            // System.out.println(userList);
        }
        return userList;
    }





}
