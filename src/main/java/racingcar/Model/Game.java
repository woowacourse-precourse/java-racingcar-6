package racingcar.Model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Car> carList = new ArrayList<>();
    private int repetition;

    public Game(List<String> carNames){
        for(String carName: carNames){
            Car car = new Car(carName);
            carList.add(car);
        }
        repetition = 0;
    }

    public void setRepetition(int repetition){
        this.repetition = repetition;
    }

    public void forward(){
        System.out.println("\n실행 결과");
        for(int i=0; i<repetition; i++){
            for(Car car: carList){
                    car.go(Randoms.pickNumberInRange(1,9));
            }
            System.out.println();
        }
    }
}
