package racingcar.domain;

import racingcar.service.GetRandomNumber;

import java.util.HashMap;
import java.util.Map;

import static racingcar.consts.ConstString.MOVE_SIZE_TRUE;
import static racingcar.consts.ConstString.GO_AHEAD;
public class CarMove {
    GetRandomNumber getRandomNumber = new GetRandomNumber();

    public void move(HashMap<String,Integer> carList){
        for (Map.Entry<String, Integer> item : carList.entrySet()) {
            if(checkMove()){
                item.setValue(item.getValue() + GO_AHEAD);
            }
        }
    }
    private boolean checkMove(){
        int randomNumber = getRandomNumber.getRandomNum();
        if(randomNumber >= MOVE_SIZE_TRUE){
            return true;
        }
        return false;
    }
}
