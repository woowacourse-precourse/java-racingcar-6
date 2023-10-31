package racingcar;

import java.util.List;
import model.Car;

public class Race {
    String position = "";

    public String raceCar(List<Car> cars, int times){
        while(times > 0){
            System.out.print("\n");

            for(int i = 0; i < cars.size(); i++){
//                int move = moveForward();
                System.out.println(cars.get(i)+" : "+position);
            }
            times--;
        }
        return "게임종료";
    }
}
