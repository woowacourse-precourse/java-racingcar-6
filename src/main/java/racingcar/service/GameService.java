package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.GameSystem;
import racingcar.repository.GameSystemRepository;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    private final int MIN=0;
    private final int MAX=9;
    private final int THRESHOLD=4;
    private final GameSystemRepository gameSystemRepository=new GameSystemRepository();

    public void saveGame(GameSystem gameSystem){
        gameSystemRepository.save(gameSystem);
    }

    public Boolean checkEnd(GameSystem gameSystem){
        return gameSystemRepository.checkComplete(gameSystem);
    }

    public void playGame(GameSystem gameSystem){
        doStopOrProceed(gameSystem);
        gameSystem.incAttemptNum();
    }

    public List<String> decideWinner(GameSystem gameSystem){
        List<Car> carList = gameSystem.getCarList();
        int maxPosition=findMaxPosition(carList);

        return findMaxPositionCarList(carList,maxPosition);
    }

    private void doStopOrProceed(GameSystem gameSystem){
        for(Car car : gameSystem.getCarList()){
            if(decideStopOrProceed()){
                car.incLocation();
            }
        }
    }

    private boolean decideStopOrProceed(){
        return Randoms.pickNumberInRange(MIN, MAX) >= THRESHOLD;
    }

    private int findMaxPosition(List<Car> carList){
        int max=-1;
        for(Car car : carList){
            if(car.getLocation()>max){
                max= car.getLocation();
            }
        }
        return max;
    }

    private List<String> findMaxPositionCarList(List<Car> carList, int maxPosition){
        List<String> result = new ArrayList<>();
        for(Car car:carList){
            if(car.getLocation()==maxPosition){
                result.add(car.getName());
            }
        }
        return result;
    }
}
