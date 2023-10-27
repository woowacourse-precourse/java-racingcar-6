package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
public class Race {

    private Car[] cars;

    public Race(String[] carNames){ // 자동차 객체마다 생성 이를 위해 Car.java 코드 구현
        this.cars = new Car[carNames.length];
        for(int i=0; i<carNames.length; i++){
            cars[i] = new Car(carNames[i]);
        }
    }

    public void moveCars(String carNames){ // 자동차 랜덤 이동 함수
        for( Car car : cars) {
            if (car.getName().equals(carNames)) {
                car.move(Randoms.pickNumberInRange(0, 9));
                break;
            }
        }
    }

    public Car[] getCars(){
        return cars;
    }

}
