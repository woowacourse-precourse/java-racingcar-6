package racingcar;

import static java.util.stream.IntStream.range;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OutputView {

    public static void printRoundResult(CarList carList){
        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < carList.round; i++){
            for (Car car : carList.carList) {
                System.out.print(car.name + " : ");
                range(0, car.randomNumList.get(i)).mapToObj(j -> "-").forEach(System.out::print);
                System.out.println();
            }
            System.out.println();
        }
    }
    public static void printWinner(List<Name> winnerList){
        System.out.print("최종 우승자 : ");

        List<String> stringlist = new ArrayList<>();
        for (Name name : winnerList){
            stringlist.add(name.getName());
        }

        String str = String.join(", ", stringlist);
        System.out.println(str);
    }
}
