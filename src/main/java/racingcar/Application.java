package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCar = Console.readLine();
        List<Car> cars = getCarNames(inputCar);
        System.out.println("시도할 회수는 몇회인가요?");
        String inputRound = Console.readLine();
        int round = getRound(inputRound);
        Game game = new Game(cars, round);
        game.play();
        System.out.println("실행 결과");

        System.out.println("최종 우승자 : " + String.join(", ", game.getWinners()));

    }

    private static int getRound(String round) {
        //만약 round가 0보다 작거나, 숫자가 아닌 경우 예외 발생
        if (Integer.parseInt(round) <= 0) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(round);
    }

    //round validate 기능, 라운드 수가 0보다 작거나 같으면 예외 발생, 숫자가 아닌 경우 예외 발생
    public static List<Car> getCarNames(String input){
        List<String> carNames = inputToList(input);
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            validateCarName(name);
            cars.add(new Car(name.trim()));
        }
        return cars;
    }
    public static List<String> inputToList(String input){
        List<String> carNames = new ArrayList<>();
        String[] splitCarName = input.split(",");
        for (String name : splitCarName) {
            carNames.add(name.trim());
        }
        return carNames;
    }
    private static void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}

