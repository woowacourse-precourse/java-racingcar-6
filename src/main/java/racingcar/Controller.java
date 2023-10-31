package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Controller {
    CarList cars;
    int round;

    Controller(){
        run();
    }

    public void run() {
        inputView();
        inGame();
        outputView();
    }

    public void inputView(){
        List<String> carName = readCarName();
        this.round = readRound();
        this.cars = new CarList(this.round, carName);
    }

    public List<String> readCarName(){
        return InputView.inputCarName();
    }
    public int readRound() {
        return InputView.inputRound();
    }

    public void inGame(){
        int randomNum;
        Car car;
        for(int i = 0; i < round ; i++){
            for(int j = 0; j < cars.carList.size(); j++) {
                randomNum = Randoms.pickNumberInRange(0,9);
                car = cars.getCar(j);
                car.addRandomNum(randomNum);
                if(randomNum >= 4){
                    car.increaseForward();
                }
            }
        }
    }

    private void outputView() {
        writeRoundResult();
        writeWinner();
    }

    private List<String> calculateOutput() {
        int max = 0;
        List<String> winnerList = new ArrayList<>();
        for(Car car : cars.carList){
            int forward = car.forward;
            if(max <= forward){
                max = forward;
                winnerList.add(car.name);
            }
        }
        return winnerList;
    }
    private void writeRoundResult(){
        OutputView.printRoundResult(cars);
    }

    private void writeWinner(){
        List<String> winnerList = calculateOutput();
        OutputView.printWinner(winnerList);
    }

}
