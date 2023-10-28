package racingcar.Controller;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.Model.Car;
import racingcar.View.InputView;
import racingcar.View.OutputView;

import java.util.ArrayList;
import java.util.List;

public class RacingController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    String[] carNameList;
    ArrayList<Car> carList = new ArrayList<>();

    public void gameStart() {
        saveCarList();
        int gameCount = inputView.inputProgressCnt();

        System.out.println("실행 결과");
        for(int i = 0; i<gameCount; i++){
            saveCarMoveNum();
            System.out.println();
        }

        checkWinner();
    }

    public void saveCarList() {
        String nameList = inputView.inputCarName();
        carNameList = nameList.split(",");
        for(int i = 0; i<carNameList.length; i++) {
            carList.add(new Car(carNameList[i]));
        }
    }

    public void saveCarMoveNum() {
        for(int i = 0; i<carList.size(); i++) {
            Car getCar =  carList.get(i);
            int randomNum = Randoms.pickNumberInRange(1,9);
            if(randomNum >= 4) {
               getCar.setMovement(getCar.getMovement()+1);
            }
            outputView.progressResult(getCar);
        }
    }

    public void checkWinner() {
        int winnerCnt = carList.get(0).getMovement();
        List<String> names = new ArrayList<>();
        names.add(carList.get(0).getCarName());

        for (int i = 1; i<carList.size(); i++) {
            if(winnerCnt <= carList.get(i).getMovement()) {
                winnerCnt = carList.get(i).getMovement();
                names.add(carList.get(i).getCarName());
            }
        }

        outputView.finishGame(names);
    }
}
