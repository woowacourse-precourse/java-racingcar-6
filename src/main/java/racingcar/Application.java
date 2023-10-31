package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

class Car {
    private String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 0;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            position++;
        }
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}



public class Application {
    private static void validateCarNames(String[] carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
    public static String printDash(int num){
        String dash = "";
        for(int i = 0; i<num; i++)
        {
            dash += "-";
        }
        return dash;
    }

    private static List<String> getWinners(List<Car> cars) {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
                winners.clear();
                winners.add(car.getName());
            } else if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println(" 경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputLine = readLine();
        String[] carNames = inputLine.split(",");
        validateCarNames(carNames);

        List<Car> carList = new ArrayList<>();
        for(String carname : carNames) {
            carList.add(new Car(carname.trim()));
        }
        System.out.println("시도할 회수는 몇회인가요?");
        Integer tryNumber = Integer.valueOf(readLine());


        System.out.println("\n실행 결과");
        for (int attempt = 0; attempt < tryNumber; attempt++) {
            for (Car car : carList) {
                car.move();
                System.out.println(car.getName() + " : " + printDash(car.getPosition()));
            }
            System.out.println();
        }

        int maxPosition = 0;
        for (Car car : carList) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        // 우승자 확인
        List<String> winners = getWinners(carList);
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
