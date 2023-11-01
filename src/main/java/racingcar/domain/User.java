package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;

public class User {
    private final int MAX_NAME_LENGTH = 5;
    private final int GO_STRAIGHT_NUMBER = 4;
    private final String INIT_CARDISTANCE = "";
    public boolean decideMove(int order){
        if(order >= GO_STRAIGHT_NUMBER){
            return true;
        }
        return false;
    }
    public int inputGameCount(){
        String userInput = Console.readLine();
        int GameCount = Integer.parseInt(userInput);
        if(GameCount <= 0){
            throw new IllegalArgumentException();
        }
        return GameCount;
    }
    public List<String> initCarList(){
        String userInput = Console.readLine();
        List<String> nameList = Arrays.asList(userInput.split(","));
        for(String name : nameList){
            if(name.length() > MAX_NAME_LENGTH){
                throw new IllegalArgumentException();
            }
        }
        return nameList;
    }
    public Map<String,String> initUser(List<String> nameList){
        HashMap<String,String> userInformation = new HashMap<>();
        for(int index = 0; index < nameList.size();index++){
            userInformation.put(nameList.get(index),INIT_CARDISTANCE);
        }
        return userInformation;
    }
}
