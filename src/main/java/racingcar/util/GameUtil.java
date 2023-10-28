package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameUtil {
    public int randomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }
    public Set<String> splitNameSet(ArrayList<Car> carArrayList){
        Set<String> nameSet = new HashSet<>();
        for(int i=0;i<carArrayList.size();i++){
            nameSet.add(carArrayList.get(i).getName());
        }
        return nameSet;
    }
    public ArrayList<Car> splitNameArrayList(String carName){
        ArrayList<Car> carArrayList = new ArrayList<>();
        String[] name = carName.split(",");
        for(int i=0;i<name.length;i++){
            carArrayList.add(new Car(name[i]));
        }
        return carArrayList;
    }
    public int winnerLocation(ArrayList<Car> carArrayList){
        int max = 0;
        for(int i=0;i<carArrayList.size();i++){
            if(carArrayList.get(i).getLocation()>max){
                max = carArrayList.get(i).getLocation();
            }
        }
        return max;
    }
    public void goAndStop(ArrayList<Car> carArrayList){
        for(int i=0;i<carArrayList.size();i++){
            isGo(carArrayList.get(i));
        }
    }

    public void isGo(Car car){
        if(randomNumber()>=4){
            car.go();
        }
    }

    public String winner(ArrayList<Car> carArrayList, int max){
        List<String> winnerArrayList = new ArrayList<>();
        for(int i=0;i<carArrayList.size();i++){
            if(carArrayList.get(i).getLocation()==max){
                winnerArrayList.add(carArrayList.get(i).getName());
            }
        }
        return String.join(", ", winnerArrayList);
    }
}
