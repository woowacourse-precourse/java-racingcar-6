package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class Game {

    public final int Max_Length = 5;
    public final int Move_Condition = 4;
    public ArrayList<Car> carMembers = new ArrayList<>();

    public String[] inputCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameAll = Console.readLine();

        if (carNameAll.isEmpty()){
            throw new IllegalArgumentException();
        }

        return carNameAll.split(",");
    }

    public void correctLength(String[] carName) {
        for (String rider : carName) {

            if ( rider.trim().isEmpty() || rider.length() > Max_Length) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void carMembersConstructor(String[] members) {
        for (String rider : members) {
            Car carMember = new Car(rider);
            carMembers.add(carMember);
        }
    }

    public int inputMoveNum() {
        System.out.println("시도할 회수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public void operate(int count) {
        System.out.println();
        System.out.println("실행 결과");

        for (int i = 0; i < count; i++) {
            for (Car currentCar : carMembers) {
                moveCar(currentCar);
            }
            printCurrentState();
        }
        printVictory();
    }

    public void moveCar(Car currentCar) {
        int dice = Randoms.pickNumberInRange(0, 9);
        if (verifyMoveCondition(dice)) {
            currentCar.dist += 1;
        }
    }

    public boolean verifyMoveCondition(int moveValue) {
        return moveValue >= Move_Condition;
    }

    public void printCurrentState() {
        for (Car currentCar : carMembers) {
            System.out.print(currentCar.name + " : ");
            for (int i = 0; i < currentCar.dist; i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void printVictory() {
        int maxDist = searchMaxDist();
        String winners = searchWinner(maxDist);
        System.out.println("최종 우승자 : " + winners);
    }

    public int searchMaxDist(){
        int maxDist = 0;
        for(Car currentCar : carMembers){
            if (currentCar.dist > maxDist){
                maxDist = currentCar.dist;
            }
        }
        return maxDist;
    }

    public String searchWinner(int maxDist){
        List<String> victory = new ArrayList<>();
        for(Car currentCar : carMembers){
            if (currentCar.dist == maxDist){
                victory.add(currentCar.name);
            }
        }
        return String.join(", ",victory);
    }

}
