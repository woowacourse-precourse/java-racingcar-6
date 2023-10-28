package racingcar.exception;

import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class InputException {
    public boolean nameLengthOver(String name){
        try {
            if(name.length()>5){
                throw new IllegalArgumentException("이름이 5글자 이하 아님");
            }
            return false;
        }catch (IllegalArgumentException illegalArgumentException){
            throw illegalArgumentException;
        }
    }

    public boolean sameName(ArrayList<Car> carArrayList){
        try {
            Set<String> nameSet = new HashSet<>();
            for(int i=0;i<carArrayList.size();i++){
                nameSet.add(carArrayList.get(i).getName());
            }
            if(nameSet.size() != carArrayList.size()){
                throw new IllegalArgumentException("같은 이름 중복");
            }
            return false;
        }catch (IllegalArgumentException illegalArgumentException){
            throw illegalArgumentException;
        }
    }
}
