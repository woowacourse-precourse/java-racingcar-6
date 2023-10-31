package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            List<Car> cars = insertCarName();
            int numberOfMoves = insertNumberOfMoves();
            playGame(cars, numberOfMoves);
            List<String> winners = getWinner(cars);
            System.out.print("최종 우승자 : " + String.join(", ", winners));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }

    }
    //경주할 자동차 이름 입력
    public static List<Car> insertCarName(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carName = input.split(",");
        List<Car> cars = new ArrayList<>();
        for(String name : carName){
            if(name.length() > 5){
                throw new IllegalArgumentException();
            }
            cars.add(new Car(name));
        }
        return cars;
    }
    //시도할 횟수 입력
    public static int insertNumberOfMoves(){
        System.out.println("시도할 회수는 몇회인가요?");
        int num = Integer.parseInt(Console.readLine());
        try{
            if(num < 0){
                throw new IllegalArgumentException();
            }
            return num;
        }catch (NumberFormatException e){
            throw new IllegalArgumentException();
        }
    }
    //게임 시작
    public static void playGame(List<Car> cars, int numberOfMove){
        System.out.println("\n실행 결과");
        for (int i = 0; i < numberOfMove; i++) {
            for (Car car : cars) {
                car.move(Randoms.pickNumberInRange(0, 9));
            }
            printCarPositions(cars);
        }
    }
    //현재 차의 위치 print 함수
    //건너 띄기 수정 해야댐
    public static void printCarPositions(List<Car> cars){
        for(Car car : cars){
            System.out.print(car.getName() + " : ");
            for(int i = 0; i < car.getPosition(); i++){
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    //우승자 구하는 함수
    //우승자 출력 이상함
    public static List<String> getWinner(List<Car> cars){
        int max = 0;
        for(Car car : cars){
            max = Math.max(car.getPosition(), max);
        }
        List<String> winner = new ArrayList<>();
        for(Car car : cars){
            if(car.getPosition() == max){
                winner.add(car.getName());
            }
        }
        return winner;
    }

}
