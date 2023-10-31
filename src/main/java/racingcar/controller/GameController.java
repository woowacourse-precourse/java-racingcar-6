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
        this.carsList = new ArrayList<>(); // Initialize the list

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
    }

    public boolean isLargeThen(int num){
        if(num >= MIN_RUNNING_SIZE){
            return true;
        }
        else{
            return false;
        }
    }
    public void playLoad(List<Cars> carsList){
        for (Cars car : carsList) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (isLargeThen(randomNumber)){
                car.upLoadState();
            }
        }
        System.out.println();
    }

    public String getResult(List<Cars> carsList){
        String winnerName="";
        int lagestLocation=0;
        int currentLocation;

        for (Cars car: carsList){
            currentLocation = car.getLength();
            if(currentLocation == lagestLocation){
                winnerName=winnerName.concat(", "+car.getName());
            }
            if(currentLocation>lagestLocation){
                lagestLocation=currentLocation;
                winnerName=car.getName();
            }
        }
        return winnerName;
    }

    public void play(){
        for(int i=0 ; i<tryNum ; i++){
            playLoad(this.carsList);

            List<String>names = new ArrayList<>();
            List<String>locations = new ArrayList<>();

            for(Cars car:carsList){
                names.add(car.getName());
                locations.add(car.getLoadState());
            }
            racingCar.showLoad(names,locations,3);
        }
        String result = getResult(this.carsList);
        System.out.println("최종 우승자 : "+result);
    }

}
