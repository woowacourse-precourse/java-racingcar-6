package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;

public class BasicController {
    List<Car> carList;
    private final String BLANK = " : ";
    private final Integer START = 0;

    public BasicController(String carInput) {
        String[] splits = carInput.split(", ");
        for(int i=0; i<splits.length; i++){
            carList.add(new Car(splits[i], START));
        }
    }

    public void tryOneGame(){
        Car currentCar = carList.iterator().next();
        while(carList.iterator().hasNext()){
            int randomValue = Randoms.pickNumberInRange(0, 9);
            currentCar.tryMove(randomValue);
            currentCar = carList.iterator().next();
        }

        // 출력
        printRoundResult();


    }

    private void printRoundResult(){
        Car currentCar = carList.iterator().next();
        while(carList.iterator().hasNext()){
            System.out.println(currentCar.getName() + BLANK + currentCar.getMoveNum());
        }
    }

}
