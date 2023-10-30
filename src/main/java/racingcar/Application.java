package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {

    public static void forward(List<Car> cars){
        for(Car c: cars) {
            if (pickNumberInRange(0, 9) >= 4) {
                c.distance += 1;
            }
        }
    }

    public static List<Car> sortCarDistance(List<Car> carList){
        Collections.sort(carList, (c1, c2) -> c2.distance - c1.distance);
        return carList;
    }

    public static List<String> winnerListGenerator(List<Car> carList){
        List<String> winners = new ArrayList<>();

        for(Car c: carList){
            if(c.distance == carList.get(0).distance){
                winners.add(c.name);
            }
        }

        return winners;
    }

    public static void main(String[] args) {

        // 차 이름 입력 안내
        Print.message(1);

        // 차 이름 입력 받기
        String[] carName = Get.carName();

        try {
            // 차 이름이 5자 초과면 예외 발생
            for(String s: carName){
                if(s.length() > 5){
                    throw new IllegalArgumentException();
                }
            }
        } catch (RuntimeException e) {
            throw new IllegalArgumentException();
        }

        // 실행 횟수 입력 안내
        Print.message(2);

        // 실행 횟수 입력 받기
        int playCount = Get.playCount();

        // car 리스트 생성
        List<Car> carList = new ArrayList<>();

        // car 객체 생성 후 리스트에 넣기
        for(String s: carName){
            Car c = new Car(s);
            carList.add(c);
        }

        // 실행 결과 출력
        Print.message(3);

        // 실행 횟수 만큼 각 car들을 전진 시키기
        for(int i = 0;i<playCount;i++){
            forward(carList);
            Print.result(carList);
            System.out.println();
        }

        // car 리스트 distance 값 기준으로 정렬하기
        carList = sortCarDistance(carList);

        // 우승자 리스트 생성
        List<String> winners = winnerListGenerator(carList);

        // 우승자 출력
        Print.winner(winners);

    }
}
