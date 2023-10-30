package racingcar;

import racingcar.domain.Car;
import camp.nextstep.edu.missionutils.Console;
import racingcar.domain.InputValidation;
import racingcar.domain.Race;

import java.util.*;

public class Application {
    public static void main(String[] args) {

        Race race = new Race();
        List<Car> cars = new ArrayList<>();
        InputValidation inputValidation = new InputValidation();
        Map<String, Integer> raceResult = new HashMap<>();
//        List<Integer> carDistances = new ArrayList<>();


        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputCarNames = Console.readLine();
//        System.out.println(inputCarNames);
        String[] carNames = inputCarNames.split(",");
//        System.out.println(Arrays.toString(carNames));

        System.out.println("시도할 회수는 몇회인가요?");
        String inputTrial = Console.readLine();
        int trial = Integer.parseInt(inputTrial); // String -> int 변경
//        System.out.println(trial);

        System.out.println("실행 결과");

        for (String carName : carNames){
            if (inputValidation.isValidName(carName)) {
                Car car = new Car(carName);
                cars.add(car);
            }
        }

        // 입력한 시도 횟수에 따른 경주 진행
        for (int i = 0; i < trial; i++){
            for (Car car : cars){
                race.startRace(car);
            }
            System.out.println();
        }

        // Map에 자동차 정보 입력 (이름, 이동 거리)
        for (Car car : cars){
            raceResult.put(car.getName(), car.getScore());
        }

//        for (String carName : raceResult.keySet()){
//            Integer distance = raceResult.get(carName);
//            System.out.println(carName + ": "+ distance);
//        }

        int maxValue = Collections.max(raceResult.values());

        List<String> maxValueKeys = raceResult.entrySet().stream()
                .filter(entry -> entry.getValue() == maxValue)
                        .map(Map.Entry::getKey)
                                .toList();

        // 최종 우승자 출력
        System.out.print("최종 우승자 : "+String.join(", ", maxValueKeys));

//        if (maxValueKeys.size() != 1){
//            for (String winner : maxValueKeys){
//                System.out.println();
//            }
//        }
//        for (String winner : maxValueKeys) {
//            if (maxValueKeys.size() != 1) {
//                System.out.print(winner + ", ");
//            } else {
//                System.out.print(winner);
//            }
//        }

//        // Value 값으로 내림차순 정렬
//        List<String> keySet = new ArrayList<>(raceResult.keySet());
//        keySet.sort(((o1, o2) -> raceResult.get(o2).compareTo(raceResult.get(o1))));
//        for (Car car : cars) {
//            int distance = car.getDistance();
//            carDistances.add(distance);
//        }
//        Collections.reverse(carDistances);
//        int maxValueCount = Collections.frequency(carDistances, carDistances.get(0));
//        if (maxValueCount >= 2){
//            for (int i = 0; i < maxValueCount; i++){
//
//            }
//        }
//        for (String key : keySet){
//            System.out.println("Car name: " + key);
//            System.out.println("Car distance: "+raceResult.get(key));
//        }
//        System.out.print("최종 우승자 : ");
    }
}
