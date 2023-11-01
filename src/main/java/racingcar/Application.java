package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        //자동차 객체들을 담을 리스트
        List<Car> cars = new ArrayList<>();
        try {
            System.out.println("경주할 자동차 이름을 입력하시오.(이름은 쉽표(,) 기준으로 구분)");
            String CarName = Console.readLine();
            if (CarName.length() == 0) {
                throw new Exception("아무런값을 입력하지 않으셨습니다.");
            }
            StringTokenizer st = new StringTokenizer(CarName, ",");
            while (st.hasMoreTokens()) {
                String car_name = st.nextToken();
                check_carName(car_name);
                cars.add(new Car(car_name, 0));
            }
        } catch (Exception e) {
            throw new IllegalArgumentException("잘못된 값을 입력하셨습니다.");
        }
    }

    //자동차 이름 확인 함수
    public static void check_carName(String car_name) throws Exception {
        if (car_name.length() > 5) {
            throw new Exception("자동차의 이름이 5글자를 넘었습니다.");
        }
    }
}
