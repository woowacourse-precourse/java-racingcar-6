package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Racing {
    final int MOVE_CRITICAL_POINT = 4;
    final int MOVE_VELOCITY = 1;
    final int RANDOM_NUMBER_START = 0;
    final int RANDOM_NUMBER_FINISH = 9;
    final int MAX_COUNT_START = 0;
    private int moveCount;
    private ArrayList<Car> carList = new ArrayList<>();

    Racing(ArrayList<String> carNames){
        MakeMoveCount();
        for(String carName : carNames){
            PutCarList(new Car(carName));
        }
    }
    void PutCarList(Car car){
        carList.add(car);
    }
    void PutMoveCount(int moveCount){
        this.moveCount = moveCount;
    }
    ArrayList<Car> GetCarList(){
        return carList;
    }
    int GetMoveCount(){
        return moveCount;
    }
    void MakeMoveCount(){
        PutMoveCount(Input.MoveCountInput());
    }

    void Move(){
        int randomCount;
        for(Car car : GetCarList()){
            randomCount = Randoms.pickNumberInRange(RANDOM_NUMBER_START
                    ,RANDOM_NUMBER_FINISH);
            MovePossible(randomCount,car);
            System.out.println(car.toString());
        }
    }

    void MovePossible(int num, Car car){
        if(num >= MOVE_CRITICAL_POINT){
            car.PlusDistance(MOVE_VELOCITY);
        }
    }

    void race(){
        int count;
        count = GetMoveCount();
        Output.ResultText();
        for(int i = 0 ; i < count ; i++){
            Move();
            System.out.println("");
        }
        Output.VictoryText(MakeVictoryList());
    }


    ArrayList<String> MakeVictoryList(){
        int maxDistance;
        ArrayList<String> result;
        maxDistance = MaxDistance(GetCarList());
        result = MaxDistanceCar(GetCarList(),maxDistance);
        return result;
    }

    int MaxDistance(ArrayList<Car> carList){
        int maxDistance = MAX_COUNT_START;
        int distance;
        for(Car car : carList){
            distance = car.GetDistance();
            if(maxDistance < distance){
                maxDistance = distance;
            }
        }
        return maxDistance;
    }
    ArrayList<String> MaxDistanceCar(ArrayList<Car> carList,int maxDistance){
        ArrayList<String> result = new ArrayList<>();
        int distance;
        for(Car car : carList) {
            distance = car.GetDistance();
            if (maxDistance == distance) {
                result.add(car.GetName());
            }
        }
        return result;
    }

}
