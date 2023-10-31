package racingcar.View;

import java.util.Map;

public class Output {

    public boolean canForward() {
        RandomNumber randomNumber = new RandomNumber();
        boolean isForward;

        int num = randomNumber.makeRandom();
        if (num >= 4) {
            isForward=true;
        } else {
            isForward=false;
        }
        return isForward;

    }

    public String saveForward(boolean isForward) {
        if(isForward){
            return "-";
        }else{
            return "";
        }

    }
    public void printRaceRound(Map<String,String> result){
        for(Map.Entry<String,String> entry: result.entrySet()){
            System.out.println(entry.getKey()+" : "+ entry.getValue());
        }
        System.out.println();
    }


}
