package racingcar.exception;

import racingcar.domain.Car;
import racingcar.util.GameUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InputException {
    GameUtil gameUtil;
    public InputException(){
        gameUtil = new GameUtil();
    }
    public void nameLengthOver(String carName){
        ArrayList<Car> carArrayList = gameUtil.splitNameArrayList(carName);
        for(int i=0;i<carArrayList.size();i++){
            String name = carArrayList.get(i).getName();
            try {
                if(name.length()>5){
                    throw new IllegalArgumentException("이름이 5글자 이하 아님");
                }
            }catch (IllegalArgumentException illegalArgumentException){
                throw illegalArgumentException;
            }
        }
    }
    public void sameName(String carName){
        ArrayList<Car> carArrayList = gameUtil.splitNameArrayList(carName);
        try {
            Set<String> nameSet = gameUtil.splitNameSet(carArrayList);
            if(nameSet.size() != carArrayList.size()){
                throw new IllegalArgumentException("같은 이름 중복");
            }
        }catch (IllegalArgumentException illegalArgumentException){
            throw illegalArgumentException;
        }
    }

}
