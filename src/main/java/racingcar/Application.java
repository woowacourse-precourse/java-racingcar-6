package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Application {
    public static void main(String[] args) {
        StartGame();
    }

    private static void StartGame() {
        Car[] cars = UserEnterCarName();

//        MakeCarObject(cars);

        int repeatNumber = UserEnterRepeatNumber();

        PlayRound(repeatNumber, cars);

        WhoIsWinner(cars);

    }

    private static void PlayRound(int repeatNumber, Car[] cars) {
        System.out.println("실행 결과");
        for(int i = 0; i< repeatNumber; i++){
        CalculateGoOrStop(cars);
        PrintResult(cars);
        }
    }

    private static void WhoIsWinner(Car[] cars) {
        int max = 0;
        StringBuilder sb = new StringBuilder();
        for(Car car : cars){
            if(car.meter > max){
                sb.setLength(0);
                max = car.meter;
                sb.append(car.name).append(", ");
            }
            else if(car.meter == max) sb.append(car.name).append(", ");
        }
        sb.setLength(sb.length() -2);
        System.out.print("최종 우승자 : " + sb);
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

    private static Car[] UserEnterCarName() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String EnteredCarName = readLine();

        String[] EnteredCars = EnteredCarName.split(",");
        for(String car : EnteredCars){
            if(car == null || car.length()>5 || car.contains(" ")) throw new IllegalArgumentException();
        }

        Car[] cars = new Car[EnteredCars.length];
        for(int i=0; i<EnteredCars.length; i++){
            cars[i] = new Car(EnteredCars[i]);
        }

        for(int i=0; i<cars.length; i++){
            cars[i] = new Car(cars[i].name);
        }

        return cars;
    }

//    private static void MakeCarObject(Car[] cars) {
//        for(int i=0; i<cars.length; i++){
//            cars[i] = new Car(cars[i].name);
//        }
//    }

    static class Car {
        String name;
        int meter;

        public Car(String name) {
            this.name = name;
            int meter = 0;
        }
    }

}
