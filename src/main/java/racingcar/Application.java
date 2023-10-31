package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;

import javax.print.attribute.PrintRequestAttribute;

class Cars {
    public final List<String> carNames;
    public final List<Integer> carNumbers;

    public Cars() {
        carNames = new ArrayList<>();
        carNumbers = new ArrayList<>();

    }

    public void addCar(String carName) {
        String[] InputArray = carName.split(",");
        for (String car : InputArray) {
            carNames.add(car.trim());
        }
        //carNames.add(carName);
    }

    public void resetBar() {
        for (int i = 0; i < carNames.size(); i++) {
            carNumbers.add(0);
        }
    }

    public void addBar(int ListNum) {
        carNumbers.set(ListNum, carNumbers.get(ListNum) + 1);
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public List<Integer> getCarNumbers() {
        return carNumbers;
    }
}

public class Application {

    public static int moves;

    public static int max_move;

    public static Cars cars = new Cars();

    public static void main(String[] args) {
        RacingStart();
    }

    public static void RacingStart() {
        HowManyCars();
        HowManyMoves();
        MoveCars();
        PresentWinner();
    }

    public static void HowManyCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String InputCars = Console.readLine();
        //List<String> cars = new ArrayList<>();
        //Cars cars = new Cars();
        cars.addCar(InputCars);
        cars.resetBar();
//        String[] InputArray = InputCars.split(",");
//        for(String car : InputArray){
//            cars.addCar(car.trim());
//        }


    }

    public static void HowManyMoves() {
        System.out.println("시도할 회수는 몇회인가요?");
        String InputMoves = Console.readLine();
        moves = Integer.parseInt((InputMoves));

    }

    public static void MoveCars() {
        for (int i = 0; i < moves; i++) {
            for (int j = 0; j < cars.carNames.size(); j++) {
                GoOrStop(j);
                PrintResult(j);
            }
            System.out.println();
        }
    }

    public static void GoOrStop(int Listnum) {
        int GoStatement = Randoms.pickNumberInRange(0, 9);
        if (GoStatement >= 4) {//4 대신 뭘 넣지
            cars.addBar(Listnum);
        }
    }

    public static void PrintResult(int Listnum) {
        System.out.print(cars.carNames.get(Listnum) + " : ");
        for (int i = 0; i < cars.carNumbers.get(Listnum); i++) {
            System.out.print("_");
        }
        System.out.println();
    }

    public static void PresentWinner() {
        System.out.print("최종 우승자 : ");
        CheckMax();
        PrintWinner();
    }

    public static void CheckMax() {
        for (int i = 0; i < cars.carNumbers.size(); i++) {
            if (max_move < cars.carNumbers.get(i)) {
                max_move = cars.carNumbers.get(i);
            }
        }
    }

    public static void PrintWinner() {
        boolean SingleWinner = true;
        for (int i = 0; i < cars.carNumbers.size(); i++) {
            if (max_move == cars.carNumbers.get(i)) {
                if (!SingleWinner) System.out.print(", ");
                System.out.print(cars.carNames.get(i));
                SingleWinner = false;
            }
        }
    }

}
