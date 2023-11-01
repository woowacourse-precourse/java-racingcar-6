package ui;

import domain.Car;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Output {

    private static StringBuilder outputBuilder;
    private static final String RESULT_PRINT_FORM = "\n실행 결과\n";
    private static final String WINNER_PRINT_FORM = "최종 우승자 : ";

    public static void init(){
        outputBuilder = new StringBuilder(RESULT_PRINT_FORM);
    }

    public static void printResult(){
        System.out.println(outputBuilder.toString());
    }

    public static void addResultOutput(Car car){
        outputBuilder.append(car.getName()).append(" : ").append(toOutputForm(car.getMoveCount())).append("\n");
    }

    public static void addResultOutput(List<Car> carList){
        outputBuilder.append(WINNER_PRINT_FORM);

        String result = carList.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        outputBuilder.append(result);
        if(carList.isEmpty()) outputBuilder.append("없습니다");
    }

    public static void addResultOutput(String input){
        outputBuilder.append(input);
    }

    //이동한 횟수만큼 출력 폼인 - 로 변환
    private static String toOutputForm(int count){
        return IntStream.range(0, count)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

}
