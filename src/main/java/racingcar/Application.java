package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;


class Cars {
    private final List<String> carNames;            //자동차의 이름
    private final List<Integer> carDistance;        //자동차가 간 거리 저장


    public Cars() {
        carNames = new ArrayList<>();
        carDistance = new ArrayList<>();
    }

    public void SetCarNames(String carName) {       //자동차 이름 setter
        int MAX_LENGTH = 5;
        String[] InputArray = carName.split(",");
        for (String car : InputArray) {
            if (car.length() > MAX_LENGTH)
                throw new IllegalArgumentException("CarName cannot exceed 5!");
            carNames.add(car.trim());
        }
    }

    public void SetCarDistance() {                  //자동차가 간 거리 setter(0값을 추가하여 초기화)
        for (int i = 0; i < carNames.size(); i++) {
            carDistance.add(0);
        }
    }

    public void AddDistance(int ListNum) {          //자동차가 움직이면 호출
        carDistance.set(ListNum, carDistance.get(ListNum) + 1);
    }

    public List<String> getCarNames() {             //자동차 이름 getter
        return carNames;
    }

    public List<Integer> getCarDistance() {         //자동차가 간 거리 getter
        return carDistance;
    }

    public Integer NumberOfCars() {                 //자동차의 개수
        return carNames.size();
    }
}

public class Application {

    public static int Total_Moves;                  //총 주어진 이동 횟수

    public static int Max_Distance;                 //참가자가 간 최장거리

    private static final Cars cars = new Cars();

    public static void main(String[] args) {
        RacingStart();                              //자동차 경주 시작
    }

    public static void RacingStart() {
        HowManyCars();                              //자동차 입력 받음
        HowManyMoves();                             //자동차 이동 횟수 입력 받음
        MoveCars();                                 //이동 여부 확인
        CheckMaxDistance();                         //참가자가 간 최장거리 확인
        PresentWinner();                            //우승자 발표
    }

    public static void HowManyCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String InputCars = Console.readLine();      //자동차 이름 입력
        cars.SetCarNames(InputCars);                //setter 로 Cars 접근
        cars.SetCarDistance();                      //setter 로 Cars 접근(0 값을 추가하여 초기화)

    }

    public static void HowManyMoves() {
        try {
            System.out.println("시도할 회수는 몇회인가요?");
            String InputMoves = Console.readLine();         //자동차 이동횟수 입력 받음
            Total_Moves = Integer.parseInt((InputMoves));
        } catch (Exception e) {                             //잘못된 입력에 대한 예외처리
            throw new IllegalArgumentException("You should input integer");
        }
    }

    public static void MoveCars() {
        for (int i = 0; i < Total_Moves; i++) {
            for (int j = 0; j < cars.NumberOfCars(); j++) {
                GoOrStop(j);                                //랜덤값에 따라 이동
                PrintResult(j);                             //이동 후 현재 이동한 거리 출력
            }
            System.out.println();
        }
    }

    public static void GoOrStop(int Listnum) {              //랜덤값을 기준으로 이동 혹은 정지
        int GO_FORWARD = 4;
        int GoStatement = Randoms.pickNumberInRange(0, 9);
        if (GoStatement >= GO_FORWARD) {
            cars.AddDistance(Listnum);
        }
    }

    public static void PrintResult(int Listnum) {               //차의 이동이 결정될 때 마다 현재 이동한 거리 출력
        List<String> nameResult = cars.getCarNames();
        List<Integer> distanceResult = cars.getCarDistance();

        System.out.print(nameResult.get(Listnum) + " : ");
        for (int i = 0; i < distanceResult.get(Listnum); i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public static void CheckMaxDistance() {                     //참가자들의 이동거리 중 가장 긴 이동거리 구하기
        List<Integer> Check = cars.getCarDistance();
        for (int Distance : Check) {
            if (Max_Distance < Distance) {
                Max_Distance = Distance;
            }
        }
    }

    public static void PresentWinner() {                        //우승자 발표
        System.out.print("최종 우승자 : ");
        boolean SingleWinner = true;                            //for 문안에서 단독 우승자인 경우 구별
        List<String> WinnerName = cars.getCarNames();
        List<Integer> WinnerDistance = cars.getCarDistance();

        for (int i = 0; i < cars.NumberOfCars(); i++) {
            if (Max_Distance == WinnerDistance.get(i)) {
                if (!SingleWinner) System.out.print(", ");
                System.out.print(WinnerName.get(i));
                SingleWinner = false;                           // 이후에 우승자가 생기면 공동우승자
            }
        }
    }

}