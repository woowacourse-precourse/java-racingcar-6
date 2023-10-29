package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.view.InputView;

public class Game {

    private int tryCount;
    private List<Car> carList;

    public void run(){
        String[] car = InputView.readCarName();
        tryCount = InputView.readTryCount();

        generateCar(car);
        start();
    }

    public void generateCar(String[] car){
        carList = new ArrayList<>();

        for(String name: car){
            carList.add(new Car(name));
        }
    }

    public void start(){
        while(tryCount > 0){
            gameByOrder();
            tryCount--;
        }
    }

    public void gameByOrder(){
        for(Car car: carList){
            int forward = moveForwardStep(getRandomNumber());
            car.setForward(forward);
        }
    }

    public int getRandomNumber (){
        return Randoms.pickNumberInRange(0,9);
    }

    public int moveForwardStep(int num){
        if(num >= 4 && num <= 9) return 1;
        return 0;
    }
}
