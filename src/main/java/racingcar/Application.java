package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        StartGame();
    }

    private static void StartGame() {
        String carNameInput = UserEnterCarName();
        Car[] cars = MakeCarObject(carNameInput);

//        for(int i=0; i<cars.length; i++){
//            System.out.println(cars[i].name+" "+cars[i].meter);
//        }

        int repeatNumber = UserEnterRepeatNumber();
//        System.out.println(repeatNumber);

        System.out.println("실행 결과");
        for(int i=0; i<repeatNumber; i++){
        CalculateGoOrStop(cars);
        PrintResult(cars);
        }

    }

    private static void PrintResult(Car[] cars) {
        for(Car car: cars){
            System.out.print(car.name + " : ");
            for(int i=0; i<car.meter; i++){
                System.out.print("-");
            }
            System.out.println();
        }System.out.println();
    }

    private static void CalculateGoOrStop(Car[] cars) {
        for(Car car : cars){
            int n = pickNumberInRange(1,9);
            if(n>=4) car.meter += 1;
        }
    }

    private static int UserEnterRepeatNumber() throws IllegalArgumentException{
        System.out.println("시도할 회수는 몇회인가요?");
        return Integer.parseInt(readLine());
    }

    private static String UserEnterCarName() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    private static Car[] MakeCarObject(String carNameInput) {
        String[] carNames = carNameInput.split(",");
        Car[] cars = new Car[carNames.length];

        for(int i=0; i<carNames.length; i++){
            cars[i] = new Car(carNames[i]);
        }

        return cars;
    }

    static class Car {
        String name;
        int meter;

        public Car(String name) {
            this.name = name;
            int meter = 0;
        }
    }

}


//    pickNumberInRange(1,9);
//    readLine();