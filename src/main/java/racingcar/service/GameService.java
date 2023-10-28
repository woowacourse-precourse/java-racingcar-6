package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import racingcar.model.Car;

public class GameService {

    public void tryRacing(ArrayList<Car> carList) {
        for (int i=0; i<carList.size(); i++) {
            Car car = carList.get(i);
            goOrStop(car);
        }
    }

    public void goOrStop(Car car) {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            car.updatePosition();
        }
    }

    public String getWinner(ArrayList<Car> carList) {
        int maxPosition = getMaxPosition(carList);
        StringBuilder sb = new StringBuilder("최종 우승자 :");
        for (int i=0; i<carList.size(); i++) {
            if(carList.get(i).getPosition() == maxPosition){
                sb.append(" " + carList.get(i).getName() + ",");
            }
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public int getMaxPosition(ArrayList<Car> carList) {
        int maxPosition = 0;
        for (int i=0; i<carList.size(); i++) {
            int position = carList.get(i).getPosition();
            if(position > maxPosition) {
                maxPosition = position;
            }
        }
        return maxPosition;
    }
}
