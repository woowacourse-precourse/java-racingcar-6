package racingcar.domain;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingGame {

    private final List<Car> cars = new ArrayList<>();
    private int round = 0;

    public void run() {
        createCars();
        inputTryCount();
        printResult();
    }

    public void createCars() {

        List<String> names;
        String[] input;

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        input = Console.readLine().split(",");
        names = Arrays.stream(input).map(String::trim).collect(Collectors.toList());
        validateNames(names);
        names.forEach(name -> cars.add(new Car(name)));
    }

    public void inputTryCount() {

        System.out.println("시도할 회수는 몇회인가요?");
        String inputTryCount = Console.readLine().trim();
        validateInputTryCount(inputTryCount);
        round = Integer.parseInt(inputTryCount);
        System.out.println();

    }

    private void printResult() {
        HashMap<String, Integer> raceResult = new HashMap<>();

        printRacingResult(raceResult);
        printWinners(raceResult);
    }

    private void printRacingResult(HashMap<String, Integer> raceResult) {
        System.out.println("실행 결과");
        for (int i = 0; i < round; i++) {
            race(raceResult);
            System.out.println();
        }
    }

    private void race(HashMap<String, Integer> raceResult) {
        cars.forEach(car -> {
            car.createRandomNumbers();
            String name = car.getName();
            int position = car.getPosition();
            raceResult.put(name, position);
            sprint(name, position);
        });
    }

    private void sprint(String name, int position) {
        StringBuilder msg = new StringBuilder(name + " : ");
        Optional<String> formattedPosition = Stream.generate(() -> "-").limit(position).reduce((a, b) -> a + b);
        formattedPosition.ifPresent(msg::append);
        System.out.println(msg);
    }

    private void printWinners(HashMap<String, Integer> raceResult) {
        int maxPosition = Collections.max(raceResult.values());

        System.out.print("최종 우승자 : ");
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
        if (name.length() < 0) {
            throw new IllegalArgumentException();
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

    private void checkOverlappingName(HashSet<String> nameSet, String name) {
        if (nameSet.contains(name)) {
            throw new IllegalArgumentException();
        }
        nameSet.add(name);
    }

    private void validateInputTryCount(String round) {
        try {
            Integer.parseInt(round);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(round) < 0) {
            throw new IllegalArgumentException();
        }
    }
}

