package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Application {
    public static void main(String[] args) {
        //자동차 객체들을 담을 리스트
        List<Car> cars = new ArrayList<>();

        //몇번 시도할것인지횟수 저장변수
        int Count;

        //가장 멀리간 자동차의 거리 저장변수
        int max_distance = 0;

        //우승자들을 나타낼 문자열
        String Winners = "";

        try {
            //자동차들의 이름 입력
            System.out.println("경주할 자동차 이름을 입력하시오.(이름은 쉽표(,) 기준으로 구분)");
            String CarName = Console.readLine();
            //미입력 예외처리
            if (CarName.length() == 0) {
                throw new Exception("아무런값을 입력하지 않으셨습니다.");
            }
            //쉽표를 기준으로 자동차 객체 생성
            StringTokenizer st = new StringTokenizer(CarName, ",");
            while (st.hasMoreTokens()) {
                String car_name = st.nextToken();
                check_carName(car_name);
                cars.add(new Car(car_name, 0));
            }

            //반복횟수 입력
            System.out.println("시도할 회수는 몇회인가요?");
            Count = Integer.parseInt(Console.readLine());

            //실행결과 출력
            System.out.println("실행결과");
            for (int i = 0; i < Count; i++) {
                //실행결과 함수 호출
                exec_result(cars);
            }

            //최종우승자 출력
            for (Car car : cars) {
                Winners = winner(car, max_distance, Winners);
            }
            System.out.println("최종 우승자 : " + Winners);

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

    //실행결과 출력함수
    public static void exec_result(List<Car> cars) {
        for (Car car : cars) {
            car.count_Random();
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    //우승자 문자열 함수
    public static String winner(Car car, int max_distance, String Winners) {
        if (car.getDistance() > max_distance) {
            max_distance = car.getDistance();
            Winners = car.getName();
        } else if (car.getDistance() == max_distance) {
            if (Winners.length() > 0) {
                Winners = Winners + ", " + car.getName();
            } else {
                Winners = car.getName();
            }
        }
        return Winners;
    }
}
