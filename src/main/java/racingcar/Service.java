package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

public class Service {
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

        for (Car car :
                carList) {
            int carDistance = car.getDistance().length();
            maxDistance = Math.max(maxDistance, carDistance);
        }
        ArrayList<String> winners = new ArrayList<>();
        for (Car car :
                carList) {
            if (maxDistance == car.getDistance().length()) {
                winners.add(car.getName());
            }
        }
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size() - 1; i++) {
            System.out.print(winners.get(i) + ", ");
        }
        System.out.println(winners.get(winners.size()-1));
    }
}
