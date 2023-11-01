package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class CarService {

    // 자동차 이름 입력
    public String[] inputCarName() {
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ");
        return Console.readLine().split(",");
    }

    // Car 객체 생성
    public ArrayList<Car> createCarImpl(String[] carNames) {
        ArrayList<Car> carList = new ArrayList<>();
        for (String carName : carNames) {
            if (carName.length() > 5) throw new IllegalArgumentException("자동차의 이름이 5자리 이상입니다.");
            carList.add(new Car(carName));
        }
        return carList;
    }

    // 시도 회수 입력
    public int tryingNumber() {
        System.out.print("시도할 회수는 몇회인가요? : ");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요");
        }
    }

    // 자동차가 움직인 거리 추가 및 출력
    public void carDistancePrint(ArrayList<Car> carList) {
        for (int i = 0; i < carList.size(); i++) {
            // random 값 생성
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if (randomNum > 3) carList.get(i).addDistance();

            System.out.println(carList.get(i).carString());
        }
        System.out.println();
    }

    // 매 회수마다 출력
    public void resultPrint(ArrayList<Car> carList, int tryNum) {
            System.out.println();
            System.out.println("실행 결과");
            for (int k = 0; k < tryNum; k++) carDistancePrint(carList);
    }

    // 게임 종료 후 우승자를 출력
    public void findWinner(ArrayList<Car> carList) {
        int maxDistance = 0;
        // 최대 거리 찾기
        for (Car car : carList) maxDistance = Math.max(maxDistance, car.getDistance().length());

        // 최대로 이동한 자동차의 이름을 List 에 추가
        ArrayList<String> winners = new ArrayList<>();
        for (Car car : carList) {
            if (maxDistance == car.getDistance().length()) winners.add(car.getName());
        }

        // List 에 값을 출력
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size() - 1; i++) System.out.print(winners.get(i) + ", ");
        System.out.print(winners.get(winners.size()-1));
    }
}
