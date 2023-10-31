package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private final List<String> cars;
    private final int num;
    private Car[] car;

    public Game(List<String> cars, int num) {
        this.cars = cars;
        this.num = num;
    }

    // 자동차 이름 길이 검사
    void checkCarName() {
        for (String s : cars) {
            if (s.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }

    // 차량 객체 이름 지정 및 이동 거리 0으로 초기화
    void initCar() {
        car = new Car[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            car[i] = new Car(cars.get(i), 0);
        }
    }

    // 랜덤 숫자가 4 이상이면 전진, 아니면 제자리
    boolean isGo() {
        int randNum = Randoms.pickNumberInRange(0, 9);
        return randNum >= 4;
    }

    // 차량별 전진 현황 출력
    void print(String name, int num) {
        System.out.print(name + " : ");
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // 매 라운드 진행
    // 랜덤 숫자 4 이상인지 확인
    void round() {
        for (int i = 0; i < cars.size(); i++) {
            if (isGo()) {
                int curMoveNum = car[i].getMoveNum();
                car[i].setMoveNum(curMoveNum + 1);
            }
            print(car[i].getName(), car[i].getMoveNum());
        }
        System.out.println();
    }

    void startGame() {
        initCar();
    }
}
