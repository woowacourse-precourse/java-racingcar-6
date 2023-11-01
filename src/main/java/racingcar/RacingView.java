package racingcar;

import java.util.Map;

import static constants.Constant.*;

public class RacingView {

    public void render(Map<String, Integer> playerResultMap){

        for(String name : playerResultMap.keySet()){
            Integer position = playerResultMap.get(name);
            String tickString = getStickString(position);
            System.out.println(name+SEP_COLON_STRING+tickString);
        }
        System.out.print(NEW_LINE_STRING);
    }

    private String getStickString(Integer position){
        String tickString = "";
        for(int i=0; i<position;i++){
            tickString+=POSITION_ONE_TICK_STRING;
        }
        return tickString;
    }
}
