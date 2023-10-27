package racingcar;

import java.util.ArrayList;
import java.util.Arrays;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

class Car{
    String name;
    int position = 0;

    Car (String name, int position) {
        if (name.length() > 5)
            throw new IllegalArgumentException("자동차의 이름은 5자 이하만 가능합니다.");
        this.name = name;
        this.position = position;
    }
    public void moveCar() {
        if (pickNumberInRange(0, 9) >= 4)
            this.position++;
    }
}

public class Application {
    public static void main(String[] args) {
        createRacingCars();

    }

    /**
     * 경주할 자동차들의 이름을 받아 이름만큼 자동차 인스턴스를 만드는 메소드
     */
    public static void createRacingCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = readLine();
        String[] carList = cars.split(",");

        // 자동차의 인스턴스 생성 및 초기화
        Car[] car = new Car[carList.length];
        for (int i = 0; i < carList.length; i++) {
            car[i] = new Car(carList[i], 0);
        }
    }

}
