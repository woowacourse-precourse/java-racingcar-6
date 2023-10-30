package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Racing;

import java.util.*;

import static java.util.Collections.list;
import static java.util.Collections.max;

public class Application {

    static int getRandomNumber() {
        // 0부터 9 사이의 무작위 값 반환
        return Randoms.pickNumberInRange(0, 9);
    }

    // 반환받은 무작위 값이 4 이상일 경우 전진
    static boolean goFront() {
        int randomNumber = getRandomNumber();
        if (randomNumber>=4) {
            return true;
        }
        return false;
    }
    public static void main(String[] args) {

        // 경주 할 자동차 이름 입력받기
        final String cars = Console.readLine();
        final List<String> carArray = List.of(cars.split(","));

        // 입력받은 자동차 이름의 자동차 클래스들 생성하기
        final List<Car> carList = new ArrayList<>();

        for (int i=0; i<carArray.size(); i++){
            final Car car = new Car(carArray.get(i));
            carList.add(car);
        }

        // 자동차 경주 게임 객체 생성해 자동차 리스트 저장하기
        final Racing racingGame = new Racing(carList);

        // 자동차 경주 시도 횟수 입력받아 저장하기
        final String racingCount = Console.readLine();
        racingGame.updateRacingCount(Integer.parseInt(racingCount));

        // 전진 횟수 카운트
        for (int i=0; i<racingGame.getRacingCount(); i++){
            for (Car car:racingGame.getRacingCarList()){
                if (goFront()) {
                    car.updateAheadCount();
                }
                // 경주 각 차수별 실행 결과 출력
                System.out.println(car.getName()+" : "+"-".repeat(car.getAheadCount()));
            }
            System.out.println("");
        }

        // 경기가 끝나면 최종 우승자 저장 및 출력
        final HashMap<String, Integer> goAheadCountList = new HashMap<>();

        for (Car car:racingGame.getRacingCarList()){
            goAheadCountList.put(car.getName(), car.getAheadCount());
        }

        goAheadCountList.forEach((key, value) -> {
            if (value == max(goAheadCountList.values())) {
                racingGame.updateWinnerList(key);
            }
        });

        System.out.println("최종 우승자 : "+racingGame.getWinnerList().toString());

    }
}
