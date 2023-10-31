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
        List<Cars> carsList = new ArrayList<>(); // Initialize the list

        int index=0;
        for(String car: resultList){
            if(index==0){
                this.tryNum = Integer.parseInt(resultList.get(0));
            }
            if(index!=0){
                Cars newCar = new Cars(car,"" );
                carsList.add(newCar);
            }
            index++;
        }

        for (Cars car : carsList) {
            System.out.println(car.getName());
        }
    }

    public boolean isLargeThen(int num){
        if(num >= MIN_RUNNING_SIZE){
            return true;
        }
        else{
            return false;
        }
    }
    public void getDice(){
        for (Cars car : carsList) {
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_SIZE, MAX_RANDOM_SIZE);
            if (isLargeThen(randomNumber)){
                car.upLoadState();
            }
            System.out.println(car.getName());
        }
    }

}
