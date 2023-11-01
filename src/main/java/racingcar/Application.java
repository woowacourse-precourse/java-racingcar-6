package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


class Cars {
    private final List<String> carNames;
    private final List<Integer> carDistance;


    public Cars() {
        carNames = new ArrayList<>();
        carDistance = new ArrayList<>();
    }

    public void SetCarNames(String carName) {
        int MAX_LENGTH = 5;
        String[] InputArray = carName.split(",");
        for (String car : InputArray) {
            if (car.length() > MAX_LENGTH)
                throw new IllegalArgumentException("CarName cannot exceed 5!");
            carNames.add(car.trim());
        }
    }

    public void SetCarDistance() {
        for (int i = 0; i < carNames.size(); i++) {
            carDistance.add(0);
        }
    }

    public void AddDistance(int ListNum) {
        carDistance.set(ListNum, carDistance.get(ListNum) + 1);
    }

    public List<String> getCarNames() {
        return carNames;
    }

    public List<Integer> getCarDistance() {
        return carDistance;
    }

    public Integer NumberOfCars() {
        return carNames.size();
    }
}

public class Application {

    public static int Total_Moves;

    public static int Max_Distance;

    private static final Cars cars = new Cars();

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
        cars.SetCarNames(InputCars);
        cars.SetCarDistance();

    }

    public static void HowManyMoves() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            String InputMoves = Console.readLine();
            Total_Moves = Integer.parseInt((InputMoves));
        } catch (Exception e) {
            throw new IllegalArgumentException("You should input integer");
        }
    }

    public static void MoveCars() {
        for (int i = 0; i < Total_Moves; i++) {
            for (int j = 0; j < cars.NumberOfCars(); j++) {
                GoOrStop(j);
                PrintResult(j);
            }
            System.out.println();
        }
    }

    public static void GoOrStop(int Listnum) {
        int GO_FORWARD = 4;
        int GoStatement = Randoms.pickNumberInRange(0, 9);
        if (GoStatement >= GO_FORWARD) {
            cars.AddDistance(Listnum);
        }
    }

    public static void PrintResult(int Listnum) {
        List<String> nameResult = cars.getCarNames();
        List<Integer> distanceResult = cars.getCarDistance();

        System.out.print(nameResult.get(Listnum) + " : ");
        for (int i = 0; i < distanceResult.get(Listnum); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void PresentWinner() {
        System.out.print("최종 우승자 : ");
        CheckMax();
        PrintWinner();
    }

    public static void CheckMax() {
        List<Integer> Check = cars.getCarDistance();
        for (int Distance : Check) {
            if (Max_Distance < Distance) {
                Max_Distance = Distance;
            }
        }
    }

    public static void PrintWinner() {
        boolean SingleWinner = true;
        List<String> WinnerName = cars.getCarNames();
        List<Integer> WinnerDistance = cars.getCarDistance();

        for (int i = 0; i < cars.NumberOfCars(); i++) {
            if (Max_Distance == WinnerDistance.get(i)) {
                if (!SingleWinner) System.out.print(", ");
                System.out.print(WinnerName.get(i));
                SingleWinner = false;
            }
        }
    }

}