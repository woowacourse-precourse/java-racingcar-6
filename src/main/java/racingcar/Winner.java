package racingcar;

import java.util.List;

public class Winner {
    public void winner(List<Car> cars) {
        System.out.printf("최종 우승자 : ");
        for(int i=0; i<cars.size(); i++) {
            if(cars.get(i).position==cars.get(i).max){
                System.out.printf(cars.get(i).getName());
            }
        }
    }
}
