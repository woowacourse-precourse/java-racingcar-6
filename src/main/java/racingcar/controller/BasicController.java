package racingcar.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;
import racingcar.response.ProcessMessage;

public class BasicController {
    List<Car> carList;
    private final String BLANK = " : ";
    private final Integer START = 0;
    private final Integer SINGLE_WINNER = 1;

    private Integer totalRound;
    private Integer currentRound;

    public BasicController(String carInput, Integer totalRound) {
        carList = new ArrayList<>();
        this.totalRound = totalRound;
        currentRound = 0;
        String[] splits = carInput.split(",");
        for(int i=0; i<splits.length; i++){
            carList.add(new Car(splits[i], START));
        }
    }

    public void tryOneGame(){
        for(int i=0; i<carList.size(); i++){
            int randomValue = Randoms.pickNumberInRange(0, 9);
            Car currentCar = carList.get(i);
            currentCar.tryMove(randomValue);
        }
        currentRound++;

        // 출력
        printRoundResult();

        // 마지막 라운드 확인
        if(lastRoundCheck()){
            Integer maxMove = findMaxMove();
            List<String> winnerList = findWinnerList(maxMove);
            printFinalResult(winnerList);
        }
    }

    private boolean lastRoundCheck(){
        if(totalRound == currentRound){
            return true;
        }
        return false;
    }

    private void printRoundResult(){
        for(int i=0; i<carList.size(); i++){
            Car currentCar = carList.get(i);
            System.out.print(currentCar.getName() + BLANK);
            for(int cnt=0; cnt<currentCar.getMoveNum(); cnt++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    private Integer findMaxMove(){
        Integer ret = 0;
        for(int i=0; i<carList.size(); i++){
            Car currentCar = carList.get(i);
            if(currentCar.getMoveNum() > ret){
                ret = currentCar.getMoveNum();
            }
        }

        return ret;
    }

    private List<String> findWinnerList(Integer threshold){
        List<String> winnerList = new ArrayList<>();

        for(int i=0; i<carList.size(); i++){
            Car currentCar = carList.get(i);
            if(currentCar.getMoveNum() == threshold){
                winnerList.add(currentCar.getName());
            }
        }
        return winnerList;
    }

    private void printFinalResult(List<String> winnerList){
        System.out.print(ProcessMessage.PRINT_FINAL_WINNER.getMsg());

        int commaCnt = winnerList.size();
        for(int i=0; i<winnerList.size(); i++){
            System.out.print(winnerList.get(i));
            if(commaCnt != SINGLE_WINNER){
                System.out.print(", ");
            }
        }
        System.out.println();
    }

}
