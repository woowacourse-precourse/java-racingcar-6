package racingcar;
import java.util.ArrayList;
import camp.nextstep.edu.missionutils.Randoms;


public class Racing {
    final int MOVE_CRITICAL_POINT = 4;
    final int MOVE_VELOCITY = 1;
    final int RANDOM_NUMBER_START = 0;
    final int RANDOM_NUMBER_FINISH = 9;
    final int MAX_COUNT_START = 0;
    private int moveCount;
    private ArrayList<Car> carList = new ArrayList<>();

    Racing(ArrayList<String> carNames) {
        makeMoveCount();
        for (String carName : carNames){
            putCarList(new Car(carName));
        }
    }

    void putCarList(Car car) {
        carList.add(car);
    }

    void putMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    ArrayList<Car> getCarList() {
        return carList;
    }

    int getMoveCount() {
        return moveCount;
    }

    void makeMoveCount() {
        putMoveCount(Input.moveCountInput());
    }

    void move() {
        int randomCount;
        for (Car car : getCarList()){
            randomCount = Randoms.pickNumberInRange(RANDOM_NUMBER_START
                    ,RANDOM_NUMBER_FINISH);
            movePossible(randomCount,car);
            System.out.println(car.toString());
        }
    }

    void movePossible(int num, Car car) {
        if (num >= MOVE_CRITICAL_POINT){
            car.PlusDistance(MOVE_VELOCITY);
        }
    }

    void race() {
        int count;
        count = getMoveCount();
        Output.resultText();
        for (int i = 0 ; i < count ; i++) {
            move();
            System.out.println("");
        }
        Output.victoryText(makeVictoryList());
    }

    ArrayList<String> makeVictoryList() {
        int maxDistance;
        ArrayList<String> result;
        maxDistance = maxDistance(getCarList());
        result = maxDistanceCar(getCarList(),maxDistance);
        return result;
    }

    int maxDistance(ArrayList<Car> carList) {
        int maxDistance = MAX_COUNT_START;
        int distance;
        for (Car car : carList){
            distance = car.GetDistance();
            if(maxDistance < distance){
                maxDistance = distance;
            }
        }
        return maxDistance;
    }

    ArrayList<String> maxDistanceCar(ArrayList<Car> carList,int maxDistance) {
        ArrayList<String> result = new ArrayList<>();
        int distance;
        for (Car car : carList) {
            distance = car.GetDistance();
            if (maxDistance == distance) {
                result.add(car.GetName());
            }
        }
        return result;
    }

}
