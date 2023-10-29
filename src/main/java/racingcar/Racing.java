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
            if(randomCount >= 4){
                car.PlusDistance(1);
            }
            System.out.println(car.toString());
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
        Output.VictoryText(Victory());
    }


    ArrayList<String> Victory(){
        int maxValue = 0;
        int distance;
        ArrayList<String> result = new ArrayList<>();
        for(Car car : GetCarList()){
            distance = car.GetDistance();
            if(maxValue < distance){
                maxValue = distance;
            }
        }

        for(Car car : GetCarList()) {
            distance = car.GetDistance();
            if (maxValue == distance) {
                result.add(car.GetName());
            }
        }
        return result;
    }
}
