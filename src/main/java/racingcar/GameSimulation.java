package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class GameSimulation {
    private List<String> user;


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
        }
        return userList;
    }

    public void gamePlay(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInput = Console.readLine();
        this.user = userInit(userInput);
        System.out.println("시도할 회수는 몇회인가요?");
        String foward=Console.readLine();
        Integer fowardTime=Integer.parseInt(foward);
        System.out.println(user);
    }





}
