package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

class Car{
    private final String carName;
    private int position;
    Car(String carName){
        this.carName = carName;
        this.position = 0;
    }
    public String getName(){
        return this.carName;
    }

    public int getPosition(){
        return this.position;
    }
    public int move(){
        int judge = Randoms.pickNumberInRange(0,9);
        if (judge >= 4) {
            position++;
        }
        return position;
    }
}
class RacingGame{
    final static String startText = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    final static String startCountText = "시도할 회수는 몇회인가요?";
    public List<String> getCarNames() {
        System.out.println(startText);
        String input = camp.nextstep.edu.missionutils.Console.readLine();
        List<String> values = Arrays.asList(input.split(","));
        values.replaceAll(String::trim);
        try{
            isVaildCarName(values);
        } catch (Exception e) {
            System.out.println("예외발생 "+e.getMessage());
            System.exit(1);
        }
        return values;
    }

    private void isVaildCarName(List<String> carNames) {
        for (String carName : carNames) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("Car name cannot exceed 5 characters: " + carName);
            }
            if (carName.isEmpty()) {
                throw  new IllegalArgumentException("Car name cannot null " + carName);
            }
        }
    }
    private int getUserInput() {
        int input = 0;
        System.out.println(startCountText);
        try {
            input = Integer.parseInt(camp.nextstep.edu.missionutils.Console.readLine());
        } catch(Exception  e){
            throw new IllegalArgumentException("Invalid input");
        }
        return input;
    }
    public void start() {
        List<String> carNames = getCarNames();
        int userInput = getUserInput();
        List<Car> cars = makeCarList(carNames);
        printState(userInput,cars);

    }

    private void printState(int userInput, List<Car> cars) {
        System.out.println("\n실행결과");
        for(int i =0; i<userInput; i++){
            for(Car car : cars){
                String middleBar = "-".repeat(car.move());
                System.out.println(car.getName()+" : "+middleBar);
            }
        }
        judgeWinner(cars);
    }

    private void judgeWinner(List<Car> cars) {
        int maxPosition = 0;
        List<String> winners = new ArrayList<>();

        // 최고 위치 찾기
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        // 최고 위치에 있는 차들을 리스트에 추가
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }

        System.out.println("\n최종 우승자 : "+String.join(", ",winners));
    }

    private List<Car> makeCarList(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        return cars;
    }


}
public class Application {
    public static void main(String[] args) {
        RacingGame game = new RacingGame();
        game.start();
    }
}
