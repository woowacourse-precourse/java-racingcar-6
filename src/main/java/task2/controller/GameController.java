package task2.controller;

import task2.racingcar.Car;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GameController {
    private static final int MIN_CAR_NAME_LENGTH = 1;
    private static final int MAX_CAR_NAME_LENGTH = 5;
    private static final int MIN_ROUND_COUNT = 1;

    private final List<Car> cars = new ArrayList<>();
    private int round;

    public void run(Scanner scanner){
        setCars(scanner);
        setRound(scanner);
        printResult();
    }

    private void setCars(Scanner scanner){
        List<String> names;
        String[] input;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        input = scanner.nextLine().split(",");
        names = Arrays.stream(input).map(String::trim).collect(Collectors.toList());
        validateNames(names);
        names.forEach(name -> cars.add(new Car(name)));
    }

    private void setRound(Scanner scanner) {
        String input;

        System.out.println("시도할 회수는 몇회인가요?");
        input = scanner.nextLine().trim();
        validateRound(input);
        round = Integer.parseInt(input);
        System.out.println();
    }

    private void printResult() {
        HashMap<String,Integer> raceResult = new HashMap<>();

        printRacingResult(raceResult);
        printWinners(raceResult);
    }

    private void printRacingResult(HashMap<String,Integer> raceResult) {
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            race(raceResult);
            System.out.println();
        }
    }

    private void race(HashMap<String,Integer> raceResult) {
        cars.forEach(car -> {
            car.run();
            String name = car.getName();
            int position = car.getPosition();
            raceResult.put(name, position);
            printEachCarRacingResult(name, position);
        });
    }

    private void printEachCarRacingResult(String name, int position) {
        StringBuilder msg = new StringBuilder(name + " : ");
        Optional<String> formattedPosition = Stream.generate(() -> "-").limit(position).reduce((a, b) -> a + b);
        formattedPosition.ifPresent(msg::append);
        System.out.println(msg);
    }

    private void printWinners(HashMap<String,Integer> raceResult) {
        int maxPosition = Collections.max(raceResult.values());

        System.out.println("최종 우승자");
        System.out.println(raceResult.entrySet().stream().filter(m -> m.getValue() == maxPosition).map(Map.Entry::getKey).collect(Collectors.joining(", ")));
    }

    private void validateNames(List<String> names) {
        HashSet<String> nameSet = new HashSet<>();
        names.forEach(name -> {
            validateName(name);
            checkOverlappingName(nameSet, name);
        });
    }

    private void validateName(String name) {
        if (name.length() < MIN_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 1자 이상이어야 한다.");
        }
        if (name.length() > MAX_CAR_NAME_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 5자 이하여야 한다.");
        }
    }

    private void checkOverlappingName(HashSet<String> nameSet, String name) {
        if (nameSet.contains(name)) {
            throw new IllegalArgumentException("[ERROR] 자동차의 이름은 고유해야만 한다.");
        }
        nameSet.add(name);
    }

    private void validateRound(String round){
        try {
            Integer.parseInt(round);
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 숫자여야 한다.");
        }
        if (Integer.parseInt(round) < MIN_ROUND_COUNT) {
            throw new IllegalArgumentException("[ERROR] 시도 횟수는 1 이상이어야 한다.");
        }
    }

}