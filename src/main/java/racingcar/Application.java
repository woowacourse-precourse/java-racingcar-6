package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Application {
    public static final Pattern CARS_PATTERN = Pattern.compile("^[a-zA-Z]{1,5}$");
    public static final Pattern ATTEMPT_PATTERN = Pattern.compile("^[1-9]\\d*$");
    static int attempt;
    static List<Car> cars = new ArrayList<>();
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        input();

        System.out.println("실행 결과");
        for (int i = 0; i < attempt; i++) {
            race();
        }

        List<String> winnerList = getWinners();
        String winners = String.join(",", winnerList);
        System.out.println("최종 우승자 : "+winners);
    }

    // 자동차는 최소 1대, 자동차 이름은 최소 1글자 ~ 최대 5글자의 알파벳
    public static void input(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        List<String> carNames = Arrays.asList(inputCarNames.split(","));

        if(carNames.isEmpty()){
            throw new IllegalArgumentException("경주를 위해서는 자동차는 최소 1대 이상 필요해요.");
        }

        for (String carName : carNames) {
            if(!CARS_PATTERN.matcher(carName).matches()){
                throw new IllegalArgumentException("자동차 이름은 1글자에서 5글자 사이의 알파벳만 가능해요.");
            }
            Car car = Car.create(carName);
            cars.add(car);
        }

        System.out.println("시도할 회수는 몇회인가요?");
        String inputAttempt = Console.readLine();
        if(!ATTEMPT_PATTERN.matcher(inputAttempt).matches()){
            throw new IllegalArgumentException("회수는 1 이상의 숫자만 입력이 가능합니다.");
        }
        attempt = Integer.parseInt(inputAttempt);

        System.out.println("");
    }

    public static void race(){
        for (Car car : cars) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.run(randomValue);
            distanceOutput(car);
        }
        System.out.println("");
    }
    private static void distanceOutput(Car car){
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < car.getDistance(); i++) {
            stringBuilder.append("-");
        }
        System.out.println(car.getName() +" : "+stringBuilder.toString());
    }

    public static List<String> getWinners(){
        List<String> winnerList = new ArrayList<>();
        int maxDistance = Integer.MIN_VALUE;
        for (Car car : cars) {
            int distance = car.getDistance();
            if(distance > maxDistance){
                maxDistance = distance;
            }
        }
        for (Car car : cars) {
            if(maxDistance == car.getDistance()){
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }
}
