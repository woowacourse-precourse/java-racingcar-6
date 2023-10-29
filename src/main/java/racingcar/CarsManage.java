package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CarsManage {
    List<Car> cars = new ArrayList<>();
    public void inputCars() {
        String carInput = Console.readLine();
        StringTokenizer stringTokenizer = new StringTokenizer(carInput, ",");

        while (stringTokenizer.hasMoreTokens()) {
            Car car = new Car();
            car.setName(stringTokenizer.nextToken());
            cars.add(car);
        }
    }

    public void straightCars (){
        int n = Integer.parseInt(Console.readLine());

        for (int i = 0; i < n; i++) {
            addStraight();
            //출력문 들어갈 자리
        }
        //전체 결과 출력 자리
    }

    public void addStraight(){
        int n;
        for (Car car:cars) {
            n = Randoms.pickNumberInRange(0,9);
            if(n>=4){
                car.addStraight();
            }
        }
    }
}
