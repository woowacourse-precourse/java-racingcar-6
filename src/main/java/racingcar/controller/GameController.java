package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Cars;
import racingcar.view.RacingCar;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static racingcar.constant.Limits.*;

public class GameController {
    private final RacingCar racingCar;
    private int tryNum;
    private List<Cars> carsList;

    public GameController(RacingCar racingCar) {
        this.racingCar = racingCar;
    }


    public void GameStart() throws IOException {
        List<String> resultList = racingCar.gameStart();
        this.carsList = new ArrayList<>();

        int index = 0;
        for (String car : resultList) {
            if (index == 0) {
//                게임 회전 횟수
                this.tryNum = Integer.parseInt(resultList.get(0));
            }
            if (index != 0) {
                Cars newCar = new Cars(car, "");
                carsList.add(newCar);
            }
            index++;
        }
    }

    public void play() {
        int carNum = this.carsList.size();
        for (int i = 0; i < tryNum; i++) {
            playDices(this.carsList);
            showLoad(this.carsList, carNum);
        }
        String result = getResult(this.carsList);
        System.out.println("최종 우승자 : " + result);
    }

    public void playDices(List<Cars> carsList) {
//        전체 차량 1회 다이스
        for (Cars car : carsList) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_SIZE, MAX_RANDOM_SIZE);
            if (randomNumber >= MIN_RUNNING_SIZE){
                car.upLoadState();
            }
        }
        System.out.println();
    }

    public void showLoad(List<Cars> carsList, int theNumOfCar) {
        List<String> names = new ArrayList<>();
        List<String> locations = new ArrayList<>();

        for (Cars car : carsList) {
            names.add(car.getName());
            locations.add(car.getLoadState());
        }
        racingCar.showLoad(names, locations, theNumOfCar);
    }

    public String getResult(List<Cars> carsList) {
        String winnerName = "";
        int lagestLocation = 0;
        int currentLocation;

        for (Cars car : carsList) {
            currentLocation = car.getLength();
            if (currentLocation == lagestLocation) {
                winnerName = winnerName.concat(", " + car.getName());
            }
            if (currentLocation > lagestLocation) {
                lagestLocation = currentLocation;
                winnerName = car.getName();
            }
        }
        return winnerName;
    }
}
