package racingcar;

import java.util.ArrayList;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.model.Car;

public class Application {
    static ArrayList<Car> carList;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] input = Console.readLine().split(",");
        carList = new ArrayList<>();
        for(String name : input) {
            if(name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이내로 작성해주세요.");
            }
            carList.add(new Car(name, 0));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        int N = Integer.parseInt(Console.readLine());


        // 주행 결과 출력
        System.out.println("\n실행 결과");

        // 랜덤으로 각 차마다 주행
        for(int i=0; i<N; i++) {
            randomDrive(carList);
            // 주행 상황 출력
            printDistance();
        }

        // 경기 결과 출력
        printResult();
    }

    static void printDistance() {
        for(Car car : carList) {
            System.out.print(car.getName() + " : ");
            for(int j=0; j<car.getCount(); j++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    static void printWinner(int maxDistance) {
        ArrayList<String> winnerList = new ArrayList<>();
        for(Car car : carList) {
            if(car.getCount() == maxDistance) {
                winnerList.add(car.getName());
            }
        }
        System.out.println("최종 우승자 : " + String.join(", ", winnerList));
    }

    static int getMaxDistance() {
        int maxDistance = 0;
        for(Car car : carList) {
            if(car.getCount() > maxDistance) {
                maxDistance = car.getCount();
            }
        }
        return maxDistance;
    }

    static void printResult() {
        // 최대거리 구하기
        int maxDistance = getMaxDistance();

        // 출력하기
        printWinner(maxDistance);
    }

    static void randomDrive(ArrayList<Car> carList) {

        for(Car car : carList) {
            int randomNum = Randoms.pickNumberInRange(0, 9);
            if(randomNum >= 4) {
                car.setCountPlus();
            }
        }
    }
}
