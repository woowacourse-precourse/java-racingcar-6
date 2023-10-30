package racingcar.Controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import racingcar.Model.Car;
import racingcar.View.InputView;
import racingcar.View.OutView;

public class RacingCarGameController {

    public void settingRacingCarGame() {
        List<String> carNameList = InputView.inputRacingCarName();
        List<Car> carList = createRacingCar(carNameList);

        String racingRoundTimes = InputView.inputRacingRoundTimes();

        startGame(carList, racingRoundTimes);
    }

    public void startGame(List<Car> carList, String racingRoundTimes) { // 이것도 분리..?
        roundProgress(carList, Integer.parseInt(racingRoundTimes));
        List<String> winnerList = caculateGameWinner(carList);
        printGameResult(winnerList);
    }

    public void printGameResult(List<String> winnerList){
        if(winnerList.size() != 1) {
            OutView.printWinnerCarList(String.join(", ", winnerList));
        }
        OutView.printWinnerCar(winnerList.get(0));
    }

    public List<String> caculateGameWinner(List<Car> carList) {
        List<String> winnerList = new ArrayList<>();
        int max=0;

        for (Car car : carList) {
            if (car.getMoveCount() > max) {
                max = car.getMoveCount();
                winnerList.clear();
                winnerList.add(car.getName());
            }else if (car.getMoveCount() == max) {
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }

    public List<Car> createRacingCar(List<String> carNameList) {
        List<Car> carList = new ArrayList<>();

        for (String carName : carNameList) {
            carList.add(new Car(carName));
        }
        return carList;
    }

    public void roundProgress(List<Car> carList, int racingRoundTimes){
        System.out.println("실행결과");
        for(int i=0; i<racingRoundTimes; i++){
            decideGoOrStop(carList);
            totalCurrentRoundResult(carList);
        }
    }

    public void totalCurrentRoundResult(List<Car> carList) {
        Map<String, Integer> roundResult = new HashMap<>();
        for(Car car: carList){
            roundResult.put(car.getName(), car.getMoveCount());
        }
        OutView.printCurrentRoundResult(roundResult);
    }

    public void decideGoOrStop(List<Car> carList){
        for (Car car : carList) {
            if(isMove()){
                car.accel();
            }
        }
    }

    public boolean isMove() { // 랜덤번호 생성
        return Randoms.pickNumberInRange(0, 9) >= 4;
    }
}
