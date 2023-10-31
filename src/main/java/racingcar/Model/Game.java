package racingcar.Model;

import static racingcar.Util.Constants.MAX_LENGTH_NAME;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Game {
    private Comparator<Car> comparator = new Comparator<Car>() {
        @Override
        public int compare(Car car1, Car car2) {
            return car2.getDistance() - car1.getDistance();
        }
    };
    private List<Car> carList = new ArrayList<>();
    private int repetition;

    public Game(List<String> carNames){
        isDuplicated(carNames);
        for(String carName: carNames){
            isLessThanMaxLength(carName);
            isBlank(carName);
            Car car = new Car(carName);
            carList.add(car);
        }
        repetition = 0;
    }

    private void isLessThanMaxLength(String name){
        if(name.length() > MAX_LENGTH_NAME){
            throw new IllegalArgumentException("최대 길이 보다 긴 이름을 입력했습니다.");
        }
    }

    private void isBlank(String name){
        if(name.isBlank()){
            throw new IllegalArgumentException("이름을 제대로 작성해주세요.");
        }
    }

    private void isDuplicated(List<String> nameList){
        Set<String> nameSet = new HashSet<String>(nameList);
        if (nameSet.size() != nameList.size()){
            throw new IllegalArgumentException("중복된 이름을 사용하였습니다.");
        }
    }

    public void setRepetition(int repetition){
        isPositiveNumber(repetition);
        this.repetition = repetition;
    }

    public void isPositiveNumber(int num){
        if(num < 0){
            throw new IllegalArgumentException("입력한 숫자가 잘못 됐습니다.");
        }
    }

    public void forward(){
        System.out.println("\n실행 결과");
        for(int i=0; i<repetition; i++){
            for(Car car: carList){
                    car.go(Randoms.pickNumberInRange(1,9));
            }
            System.out.println();
        }
    }

    public void result(){
        carList.sort(comparator);
        Car winner = carList.get(0);
        winner.win();
        for(int i =1; i< carList.size(); i++){
            Car car = carList.get(i);
            if(car.getDistance() == winner.getDistance()){
                car.jointWin();
            }
        }
    }
}
