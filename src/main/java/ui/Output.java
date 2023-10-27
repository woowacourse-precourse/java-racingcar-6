package ui;

import java.util.List;
import java.util.stream.Collectors;

public class Output {

    public static void printResult(List<?> list){
        System.out.println("\n실행 결과");
        list.forEach(object -> System.out.println(object.toString()));

        System.out.println();
    }

    public static void printWinner(List<?> list){
        System.out.println("\n최종 우승자 : ");
        String result = list.stream()
                .map(Object::toString)
                .collect(Collectors.joining(", "));

        System.out.println();
    }
}
