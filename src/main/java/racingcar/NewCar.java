package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NewCar {
    String carName;
    Integer distance = 0;

    public NewCar(String carName){
        this.carName = carName;
    }

    public void carShouldGo(){
        int randNum = Randoms.pickNumberInRange(0,9);
        if (randNum >= 4){
            this.distance++;
        }
    }

    public int getDistance(){
        return distance;
    }

    public void currentDistance(){
        System.out.printf("%s : ", this.carName);
        for (int i=0; i<this.distance; i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static List<NewCar> findMaxDistance(List<NewCar> carList){
        List<NewCar> maxCars = new ArrayList<>();
        if (carList.isEmpty()){
            return maxCars;
        }
        int maxDistance = Integer.MIN_VALUE;
        for (NewCar car : carList) {
            if (car.getDistance() > maxDistance){
                maxCars.clear();
                maxCars.add(car);
                maxDistance = car.getDistance();
            } else if (car.getDistance() == maxDistance) {
                maxCars.add(car);
            }
        }

        return maxCars;
    }
}
