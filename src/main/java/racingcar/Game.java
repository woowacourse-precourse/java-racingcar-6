package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Game {

    private int tryCount;
    private List<Car> carList;

    public void run(){
        String[] car = InputView.readCarName();
        tryCount = InputView.readTryCount();

        generateCar(car);
        start();
        findWinners();
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
            printGameByOrder();
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

    public void printGameByOrder(){
        for(Car car: carList) {
            OutputView.printGameResultByOrder(car.getName(), car.getForward());
        }
        OutputView.println();
    }

    public void findWinners() {
        int maxForward = -1;
        List<String> winner = new ArrayList<>();

        for (Car car : carList) {
            int carForward = car.getForward();
            if (carForward > maxForward) {
                maxForward = carForward;
                winner.clear();
                winner.add(car.getName());
            } else if (carForward == maxForward) {
                winner.add(car.getName());
            }
        }

        printWinner(winner);
    }

    public void printWinner(List<String> winner){
        if(winner.size() == 1)
            OutputView.printSoloWinner(winner.get(0));
        else
            OutputView.printJointWinner(winner);
    }
}
