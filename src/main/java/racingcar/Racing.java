package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Racing {
    private int count;
    private ArrayList<Car> carList = new ArrayList<>();

    Racing(ArrayList<String> carNames){
        MakeCount();
        for(String carName : carNames){
            PutCarList(new Car(carName));
        }
    }
    void PutCarList(Car car){
        carList.add(car);
    }
    void PutCount(int count){
        this.count = count;
    }
    ArrayList<Car> GetCarList(){
        return carList;
    }
    int GetCount(){
        return count;
    }
    void MakeCount(){
        PutCount(Input.CountInput());
    }

    void Move(){
        int randomCount;
        for(Car car : GetCarList()){
            randomCount = Randoms.pickNumberInRange(0,9);
            MovePossible(randomCount,car);
            System.out.println(car.toString());
        }
    }

    void MovePossible(int num, Car car){
        if(num >= 4){
            car.PlusDistance(1);
        }
    }

    void race(){
        int count;
        count = GetCount();
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
        int maxDistance = 0;
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
