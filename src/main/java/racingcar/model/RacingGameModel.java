package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import racingcar.util.Util;

public class RacingGameModel {


    // 입력받은 자동차의 이름들을 List<Car>로 바꿔서 return하는 메서드
    public List<Car> stringToList(String carNames) {
        String[] carNameArray = carNames.split(",");
        List<Car> cars = new ArrayList<>();

        for (String name : carNameArray) {
            cars.add(new Car(name));
        }

        return cars;
    }

    // 한 라운드를 실행하는 메서드. 각 자동차들은 전진하거나 멈춰있는다.
    public void playOneRound(List<Car> cars) {
        for(Car car: cars) {
            if(Util.isSameOrBiggerThanFour(Randoms.pickNumberInRange(0,9))){
                car.go();
            }
        }
    }

    // 승리한 자동차 List를 넘겨주는 메서드
    public List<Car> pickWinners(List<Car> cars){
        List<Car> winners = new ArrayList<>();
        int maxCount = 0;

        for(Car car: cars){
            if(isCarMoreAdvanced(maxCount, car)){
                maxCount = car.getForwardCount();
            }
        }
        for(Car car: cars){
            if(isCarWinner(maxCount, car)){
                winners.add(car);
            }
        }
        return winners;
    }

    private static boolean isCarWinner(int maxCount, Car car) {
        return car.getForwardCount() == maxCount;
    }

    private static boolean isCarMoreAdvanced(int maxCount, Car car) {
        return car.getForwardCount() > maxCount;
    }


}
