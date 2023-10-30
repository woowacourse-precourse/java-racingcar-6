package racingcar;

import java.util.ArrayList;
import java.util.List;

import static racingcar.ValidCheckAndParse.carNameParseAndValidCheck;

public class Game {
    private List<Car> cars = new ArrayList<>();
    public Game(){}

    /**
     * 자동차 이름 전체를 받아 carNameParseAndValidCheck 함수를 호출하여 유효성 검사와 parsing 진행.
     * cars에 새로운 자동차들을 생성하여 저장한다.
     */
    public void addCar(String carNames){
        String[] strings = carNameParseAndValidCheck(carNames);
        for (String carName:strings) {
            cars.add(new Car(carName));
        }
    }

    /**
     * 자동차들을 움직이는 함수.
     * ArrayList에 저장되어 있는 자동차들의 move 함수를 호출한다.
     */
    public String move(){
        String res="";
        for (Car car:cars) {
            car.move();
            res+= car.toString();
        }
        return res;
    }

    /**
     * 레이싱의 결과를 나타내는 함수.
     * 현재 자동차들을 비교하여 가장 멀리 이동한 자동차들의 이름을 조합하여 리턴한다.
     */
    public String end(){
        String res="";
        boolean isFirst=true;
        int maxDistance=0;
        for(Car car:cars){
            if(car.getDistance()>maxDistance){
                maxDistance=car.getDistance();
            }
        }

        for(Car car:cars){
            if(car.getDistance()==maxDistance){
                if(isFirst){
                    res+=car.getName();
                    isFirst=false;
                }else{
                    res+=", ";
                    res+=car.getName();
                }
            }
        }
        return res;
    }
}
