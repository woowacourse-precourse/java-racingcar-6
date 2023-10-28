package racingcar;
import java.util.*;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static class Car{
        private final String name;
        private int position = 0;
        public Car(String name){
            this.name = name;
        }

        public void tryMove(int randomNumber){
            if(randomNumber>=4){
                this.position++;
            }
        }

        public int getPosition(){
            return this.position;
        }
        public String getName(){
            return this.name;
        }
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 자동차 만들기
        List<Car> cars = makeCars();

        // 자동차 경주 진행
        int attempts = getAtteptsNum();
        runningRace(cars, attempts);

        // 결과
        printWinners(getWinners(cars));

    }

    public static List <Car> makeCars(){

        List<Car> cars = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        // 입력받은 자동차 이름 cars에 저장
        String[] carNames = Console.readLine().split(",");
        for(String name : carNames){
            cars.add(new Car(name));
        }

        return cars;
    }

    public static int getAtteptsNum(){

        System.out.println("시도할 회수는 몇회인가요?");
        int attemptsNum = Integer.parseInt(Console.readLine());
        System.out.println();

        return attemptsNum;
    }

    public static void runningRace(List<Car> cars, int attemptsNum){

        System.out.println("실행 결과");
        for(int attempt = 0; attempt<attemptsNum; attempt++){

            for(Car car : cars){
                car.tryMove(Randoms.pickNumberInRange(0, 9));
                printRoundResult(car);
            }
            System.out.println();
        }
    }

    public static void printRoundResult(Car car){
        System.out.print(car.name+" : ");
        for(int i = 0; i<car.position;i++){
            System.out.print("-");
        }
        System.out.println();
    }

    public static List<Car> getWinners(List<Car> cars){

        List<Car> winners = new ArrayList<>();

        int maxPosition = getMaxPosition(cars);

        for(Car car : cars){
            if(car.position == maxPosition){
                winners.add(car);
            }
        }

        return winners;
    }

    public static int getMaxPosition(List<Car> cars){
        int maxPosition = 0;

        for(Car car : cars){
            if(maxPosition<car.getPosition()){
                maxPosition = car.getPosition();
            }
        }

        return maxPosition;
    }

    public static void printWinners(List<Car> winners){

    }
}
