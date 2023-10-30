package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Race {

    List<Car> cars = new ArrayList<>();

    int play_count;

    public void startGame() {
        setCarName();
        setPlayCount();

        System.out.println("실행 결과");

        for (int i = 0; i < play_count; i++) {
            play();
            System.out.println();
        }

        result();
    }

    private void setCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        List<String> car_name = List.of(Console.readLine().split(","));
        car_name.stream().forEach(name -> cars.add(new Car(name)));
    }

    private void setPlayCount() {
        System.out.println("시도할 회수는 몇회인가요?");
        play_count = Integer.parseInt(Console.readLine());
    }

    private void play() {
        cars.forEach(car -> {
            car.move();
            String name = car.getName();
            int score = car.getScore();
            printEachCarResult(name, score);
        });
    }

    private void printEachCarResult(String name, int score) {
        StringBuilder result = new StringBuilder(name + " : ");
        Optional<String> formattedPosition = Stream.generate(() -> "-").limit(score).reduce((a, b) -> a + b);
        formattedPosition.ifPresent(result::append);
        System.out.println(result);
    }

    private void result() {
        StringBuilder result = new StringBuilder();
        result.append("최종 우승자 : ");

        int max_score = cars.stream().max(Comparator.comparingInt(Car::getScore)).get().getScore();
        result.append(cars.stream().filter(Car -> Car.getScore() == max_score).map(Car -> Car.getName()).collect(Collectors.joining(", ")));

        System.out.println(result);
    }

}
