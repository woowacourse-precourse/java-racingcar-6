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
            int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_SIZE, MAX_RANDOM_SIZE);
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

    public boolean isAbleName(String name){
        if(name.length()>MAX_NAME_SIZE){
            return false;
        }
        return true;
    }

    public void play(){
        int carNum = this.carsList.size();
        for(int i=0 ; i<tryNum ; i++){
            playLoad(this.carsList);

            List<String>names = new ArrayList<>();
            List<String>locations = new ArrayList<>();

            for(Cars car:carsList){
                if(isAbleName(car.getName())){
                    names.add(car.getName());
                    locations.add(car.getLoadState());
                }
                else{
                    throw new IllegalArgumentException("사용 가능한 최대 글자수는 5 입니다.");
                }
            }
            racingCar.showLoad(names,locations,carNum);
        }
        String result = getResult(this.carsList);
        System.out.println("최종 우승자 : "+result);
    }

}
