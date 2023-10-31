package domain;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Cars {
    public void setCars(List<String>cars){
        List<String> initCar = new ArrayList<String>();
        for (int i=0;i<cars.size();i++){
            initCar.add("");
        }

    }
    public void move(List<String> cars){
        for (int i=0;i<cars.size();i++){
            if(randomNum()){

            }else {

            }
        }

    }
    public boolean randomNum(){
        int num = Randoms.pickNumberInRange(0,9);
        if (num>=4){
            return true;
        }else {
            return false;
        }
    }
}
