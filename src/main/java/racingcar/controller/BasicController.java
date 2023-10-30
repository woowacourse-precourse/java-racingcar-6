package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class BasicController {
    List<Car> carList;
    private final String BLANK = " : ";
    private final Integer START = 0;

    public BasicController(String carInput) {
        carList = new ArrayList<>();
        String[] splits = carInput.split(",");
        for(int i=0; i<splits.length; i++){
            carList.add(new Car(splits[i], START));
        }
    }

    public void tryOneGame(){
        for(int i=0; i<carList.size(); i++){
            int randomValue = Randoms.pickNumberInRange(0, 9);
            Car currentCar = carList.get(i);
            currentCar.tryMove(randomValue);
        }

        // 출력
        printRoundResult();


    }

    private void printRoundResult(){
        for(int i=0; i<carList.size(); i++){
            Car currentCar = carList.get(i);
            System.out.print(currentCar.getName() + BLANK);
            for(int cnt=0; cnt<currentCar.getMoveNum(); cnt++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

}
