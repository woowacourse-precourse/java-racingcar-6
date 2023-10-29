package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Service {

    // 자동차 이름 입력
    public String[] inputCarName() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ");
        return Console.readLine().split(",");
    }

    // Car 객체 생성
    public ArrayList<Car> createCarImpl() {
        // carList return 필요
        ArrayList<Car> carList = new ArrayList<>();
        for (String carName :
                inputCarName()) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차의 이름이 5자리 이상입니다.");
            }
            carList.add(new Car(carName));
        }
        return carList;
    }

    // 매 회수마다 출력
    public void resultPrint(ArrayList<Car> carList) {
        System.out.print("시도할 회수는 몇회인가요? : ");
        int tryingNumber = Integer.parseInt(Console.readLine());
        System.out.println();
        System.out.println("실행 결과");
        for (int k = 0; k < tryingNumber; k++) {
            carDistancePrint(carList);
        }
    }

    // 자동차가 움직인 거리 추가 및 출력
    public void carDistancePrint(ArrayList<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {

            // random 값 생성
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum > 3) {
                carList.get(i).addDistance();
            }
            // 출력
            String carString = carList.get(i).carString();
            System.out.println(carString);
        }
        System.out.println();
    }

    // 게임 종료 후 우승자를 출력
    public void findWinner(ArrayList<Car> carList) {
        int maxDistance = 0;
        // 최대 거리 찾기
        for (Car car :
                carList) {
            int carDistance = car.getDistance().length();
            maxDistance = Math.max(maxDistance, carDistance);
        }
        // 최대로 이동한 자동차의 이름을 List 에 추가
        ArrayList<String> winners = new ArrayList<>();
        for (Car car :
                carList) {
            if (maxDistance == car.getDistance().length()) {
                winners.add(car.getName());
            }
        }
        // List 에 값을 출력
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size() - 1; i++) {
            System.out.print(winners.get(i) + ", ");
        }
        System.out.println(winners.get(winners.size()-1));
    }
}
