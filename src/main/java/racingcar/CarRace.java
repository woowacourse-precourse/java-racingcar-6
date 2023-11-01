package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CarRace {

    public CarRace() {
    }

    public void doCarRace() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameLine = Console.readLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        String[] carNames = carNameLine.split(",");
        List<Car> cars = new ArrayList<>();
        for (String name : carNames) {
            cars.add(new Car(name));
            // 이름이 5자 이상이거나 숫자를 포함한 경우 예외를 던짐
            if (name.length() > 5 || name.contains("1")) {
                throw new IllegalArgumentException();
            }
        }

        System.out.println("실행 결과");
        for(int i=0; i<tryCount; i++) {
            for(Car car : cars) {
                int pickupNum = Randoms.pickNumberInRange(0,9);
                if(pickupNum >=4) {
                    int forwardNum = car.getForward();
                    car.setForward(forwardNum+1);
                }
                System.out.print(car.getName() + " : ");
                for(int j=0; j<car.getForward(); j++) {
                    System.out.print("-");
                }
                System.out.println();
            }
            System.out.println();
        }

        System.out.print("최종 우승자 : ");
        int maxNum=0;
        int checkMaxNum=0;
        for(Car winnerCar: cars) {
            if(winnerCar.getForward() > maxNum) {
                maxNum = winnerCar.getForward();
            }
        }

        List<String> winners = new ArrayList<>();
        for(Car winnerCar: cars) {
            if(winnerCar.getForward() == maxNum) {
                winners.add(winnerCar.getName());
            }
        }

        for(int j=0; j<winners.size(); j++) {
            System.out.print(winners.get(j));
            if(j < winners.size() -1) {
                System.out.print(", ");
            }
        }
    }
}
