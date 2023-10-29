package racingcar.view;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

import java.util.List;
import java.util.StringJoiner;

public class PlayeroutputView {
    public static void round(List<Car> cars){
        for(Car car : cars){
            String carName = car.getName();
            String onestepMessage = "-";
            System.out.println(carName + ":" + onestepMessage.repeat(car.getPosition()));
        }
        System.out.println(" ");
    }

    public static void updateRound(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum >= 4) {
                cars.get(i).setPosition(cars.get(i).getPosition() + 1);
            }
        }
    }

    public static int result(List<Car> cars){
        int max = 0;
        for(int i=0; i< cars.size(); i++){
            if (max<cars.get(i).getPosition()){
                max = cars.get(i).getPosition();
            }
        }
        return max;
    }

}