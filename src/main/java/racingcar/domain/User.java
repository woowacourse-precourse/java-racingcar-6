package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    public List<Car> nameForCar(int names){

        return null;
    }

    public int fillInMovingNumber(){
        return 0;
    }

    private boolean validateName(int name){
        return false;
    }

    private List<String> separateNames(String names){
        String[] temp=names.split(",");
        List<String> cars=new ArrayList<>(Arrays.asList(temp));
        return cars;
    }


}
