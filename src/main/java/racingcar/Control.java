package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Control {
    static int tryNumber;
    static List<String> winnerName = new ArrayList<>();
    static List<String> names = new ArrayList<>();
    static List<Car> Cars = new ArrayList<>();

    void createObjects() { // Car 객체 생성
        for (String name : names) {
            if(name.length() > 5){
                throw new IllegalArgumentException();
            }
            Car car = new Car(name);
            Cars.add(car);
        }
    }

    void stringToList(String names) { // 자동차 이름 -> List에 저장
        Control.names = List.of(names.split(","));
        createObjects();
    }

    void setTryNumber(String tryNumber) { // 시도 횟수 저장
        Control.tryNumber = Integer.parseInt(tryNumber);
    }

    static public void playGame() {
        for (int i = 0; i < tryNumber; i++) {
            for (int j = 0; j < names.size(); j++) { // 난수가 4이상이면 자동차 이동
                int randomNumber = Randoms.pickNumberInRange(1, 9);
                if (randomNumber >= 4) {
                    Cars.get(j).moveCount++;
                }
            }
            View.print("Progress");
        }
    }

    static public void calculateWinner() {
        int max = -1;
        for(Car car: Cars) {
            if(car.moveCount > max){
                max = car.moveCount;
            }
        }
        for(Car car: Cars){
            if(car.moveCount == max){
                winnerName.add(car.name);
            }
        }
    }
}
