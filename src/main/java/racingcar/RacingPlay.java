package racingcar;

import java.util.ArrayList;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;


public class RacingPlay {
    private int racingTryNum = 0;
    private ArrayList<RacingCar> racingCarList = new ArrayList<RacingCar>();

    public RacingPlay(String carNames, int racingTryNum){
        this.racingTryNum = racingTryNum;
        setRacingCarList(carNames);
    }
    private void setRacingCarList(String carNames){
        String[] carNameArray = carNames.split(",");
        for(int i = 0; i<carNameArray.length; i++){
            racingCarList.add(new RacingCar(carNameArray[i]));
        }
    }

    public void oneTryRacing(){
        for(RacingCar car : racingCarList){
            int randomNum = pickNumberInRange(0, 9);
            if(randomNum>=4){
                car.oneStepMovingCar();
            }
        }
    }

    public void viewCurrentRacingResult(){
        for(RacingCar car : racingCarList){
            System.out.println(car.getCarName()+" : "+"-".repeat(car.getCarMovingNum()));
        }
    }

    public void viewRacingWinner(){
        String winners = new String();
        int maxMoving = 0;
        for(RacingCar car : racingCarList){
            if(car.getCarMovingNum()>maxMoving) {
                maxMoving = car.getCarMovingNum();
            }
        }
        for(RacingCar car : racingCarList){
            if(car.getCarMovingNum() == maxMoving){
                winners += car.getCarName() + ", ";
            }
        }
        System.out.println("최종 우승자 : " + winners.substring(0, winners.length()-2));
    }
}
