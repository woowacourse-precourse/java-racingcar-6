package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class Application {
    public static void main(String[] args) {

        String cars;
        int trialNumber;

        // 경주할 자동차 이름 (쉼표로 구분)
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        cars = Console.readLine();

        // 이름은 5자 이하만 가능
        List<Car> carList = new ArrayList<>();
        for (int i =0; i < cars.split(",").length; i++){

            if(cars.split(",")[i].length() > 5) {
                throw new IllegalArgumentException("자동차 이름의 숫자는 5자리 이하만 가능합니다.");
            }
            carList.add(new Car(cars.split(",")[i]));
        }


        // 시도할 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        trialNumber = Integer.parseInt(Console.readLine());

        if(trialNumber <= 0) {
            throw new IllegalArgumentException("시도할 회수는 1회 이상이어야 합니다.");
        }
        // 차수별 실행 결과 출력
        for(int i = 0; i < trialNumber; i++) {
            for (Car car : carList) {
                goRacing(car);
                System.out.print(car.getName() + " : ");
                printDistance(car);
                System.out.println(" ");

            }
            System.out.println();
        }

        // 우승자 안내
        List<String> winnerList = pickWinner(carList);
        String winners = String.join(",", winnerList) ;
        System.out.print("최종 우승자 : " + winners);

    }

    // 1회 랜덤 게임 진행
    public static Car goRacing(Car car) {
        int diceResult = Randoms.pickNumberInRange(0,9);
        if(diceResult > 3) {
            int distance = car.getDistance();
            car.setDistance(distance + 1);
        }
        return car;
    }

    // 거리값 출력
    public static void printDistance(Car car){
        int printDistance = car.getDistance();
        for(int i = 0; i < printDistance; i++){
            System.out.print("-");
        }
    }

    // 승자 비교
    public static List<String> pickWinner(List<Car> carList){

        List<String> winnerList = new ArrayList<>();

        int largestInt = carList.get(0).getDistance();
        // 최고 숫자 찾기
        for (Car car:carList) {
            if(largestInt <= car.getDistance()) {
                largestInt = car.getDistance();
            }
        }

        // 최고 숫자 가진 car 찾기
        for (Car car:carList) {
            if(car.getDistance() == largestInt) {
                winnerList.add(car.getName());
            }
        }

        return winnerList;
    }
}
