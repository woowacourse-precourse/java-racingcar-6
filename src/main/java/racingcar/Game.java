package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;

public class Game {
    private List<Car> cars;
    private int gameCount;

    public void runGame(){
        // 각 차 별 전진 거리 부여
        for(Car car: cars) {
            int mileage = Randoms.pickNumberInRange(0, 9);
            car.plusMileage(mileage);
            printGameResult(car.getCarName(), mileage);
        }
    }

    public void printGameResult(String carName, int mileage){
        System.out.print(carName + " : ");
        for(int mile=mileage; mile>=0; mile--){
            System.out.print("-");
        }
        System.out.print("\n\n");
    }

    public void setGameCount(int cnt){
        if(cnt > 0){
            gameCount = cnt;
        } else{
            throw new IllegalArgumentException();
        }
    }

    public int getGameCount() {
        return gameCount;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
//        mileages = new int[cars.size()];
    }

    public void printFinalGameResult() {
        List<Car> winners = getWinner();
        int winnersCnt = winners.size();
        System.out.print("최종 우승자 : ");

        for (int index = 0; index < winnersCnt; index++) {
            System.out.print(winners.get(index).carName);
            if (index != winnersCnt - 1) {
                System.out.println(", ");
            }
        }
    }

    private List<Car> getWinner(){
        List<Car> winners = new ArrayList<>();
        // 가장 많은 주행거리의 차량 찾기
        int maxMileage = 0;
        for(Car car: cars){
            if(car.getMileage() > maxMileage){
                winners = new ArrayList<>();
                winners.add(car);
            } else if(car.getMileage() == maxMileage){
                winners.add(car);
            }
        }
    }
}

