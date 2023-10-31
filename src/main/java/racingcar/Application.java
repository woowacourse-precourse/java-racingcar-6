package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;

class Car {
    private String name;
    private String distance;

    Car(String name, String distance) {
        this.name = name;
        this.distance = distance;
    }

    String getName() {
        return this.name;
    }

    String getDistance() {
        return this.distance;
    }

    void setName(String name) {
        this.name = name;
    }

    void setDistance(String distance) {
        this.distance = distance;
    }

}

class InsertionNameAndResetDistance {
    public static void resetNameAndDistance(ArrayList<Car> carList, String[] carNameList) {
        int i;
        for (i = 0; i < carNameList.length; i++) {
            carList.add(new Car(carNameList[i], ""));
        }
    }
}

class CheckNames {
    public static boolean CheckNamesInCarList(ArrayList<Car> carList) {
        int result = 0;

        for (int i = 0; i < carList.size(); i++)
            if (carList.get(i).getName().length() > 5) {
                result = 1;
                break;
            }

        if (result == 1)
            return true;
        else
            return false;
    }
}

class UpdateDistance {
    private int makeRandomNumber() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        return randomNumber;
    }

    private void updateCheck(Car car) {
        if (makeRandomNumber() >= 4) {
            String distance = car.getDistance();
            distance = distance.concat("-");
            car.setDistance(distance);
        }
    }

    void updateCarDistance(ArrayList<Car> carList) {
        for (int i = 0; i < carList.size(); i++)
            updateCheck(carList.get(i));
    }

}

class PrintCurrentCondition {
    static void printDistance(ArrayList<Car> carList) {
        for (int i = 0; i < carList.size(); i++)
            System.out.println(carList.get(i).getName() + " : " + carList.get(i).getDistance());
        System.out.println("");
    }

    static void printWinner(ArrayList<String> winnerList) {
        System.out.print("최종 우승자 :");
        for (int i = 0; i < winnerList.size(); i++) {
            System.out.println(" " + winnerList.get(i));
            if (i != winnerList.size() - 1)
                System.out.print(",");
        }
    }
}

class SelectWinner {
    private int compareAndUpdateMaxDistance(Car car, int max) {
        if (car.getDistance().length() >= max)
            return car.getDistance().length();
        else
            return max;
    }

    private int chooseMaxDistance(ArrayList<Car> carList) {
        int max = 0;
        for (int i = 0; i < carList.size(); i++)
            max = compareAndUpdateMaxDistance(carList.get(i), max);
        return max;
    }

    private void insertionWinnerList(ArrayList<String> winnerList, Car car, int max){
        if (car.getDistance().length() == max)
            winnerList.add(car.getName());
    }
    ArrayList<String> chooseWinner(ArrayList<Car> carList){
        ArrayList<String> winnerList = new ArrayList<String>();
        int max = chooseMaxDistance(carList);
        for(int i = 0; i < carList.size(); i++)
            insertionWinnerList(winnerList, carList.get(i), max);
        return winnerList;
    }

}

class RacingCar {
    public static void start() {
        ArrayList<Car> carList = new ArrayList<Car>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNameList = Console.readLine().split(",");
        InsertionNameAndResetDistance.resetNameAndDistance(carList, carNameList);

        System.out.println("시도할 회수는 몇회인가요?");
        int trying = Integer.parseInt(Console.readLine());
        System.out.println("");

        if (CheckNames.CheckNamesInCarList(carList))
            throw new IllegalArgumentException();

        System.out.println("실행 결과");
        int roundCount = 0;
        while (roundCount < trying) {
            UpdateDistance updateDistance = new UpdateDistance();
            updateDistance.updateCarDistance(carList);
            PrintCurrentCondition.printDistance(carList);
            roundCount++;
        }

        SelectWinner selectWinner = new SelectWinner();
        ArrayList<String> winnerList = selectWinner.chooseWinner(carList);
        PrintCurrentCondition.printWinner(winnerList);
    }
}

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        RacingCar.start();
    }
}
