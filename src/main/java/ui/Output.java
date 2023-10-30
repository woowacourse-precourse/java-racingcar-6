package ui;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Output {

    public static void printResult(List<Car> list){
        System.out.println("\n실행 결과");
        list.forEach(car -> System.out.println(car.getName() + " : " +
                toOutputForm(car.getMoveCount())));

        System.out.println();
    }

    //이동한 횟수만큼 출력 폼인 - 로 변환
    private static String toOutputForm(int count){
        return IntStream.range(0, count)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

    public static void printWinner(List<Car> list){
        System.out.print("\n최종 우승자 : ");

        String result = list.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.println(result);
    }
}
