package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Result {
    ArrayList<Car> userArray = new ArrayList<>();

    Result(ArrayList<Car> userArray) {
        this.userArray = userArray;
    }

    public void finalWinner() {
        List<Integer> countArray = userArray.stream()
                .map(Car::getCount)
                .toList();  // [3,2,3] // 꿀팁 감사합니다.

        int maxNumber = Collections.max(countArray); // 가장 큰 값

        List<Integer> result = IntStream.range(0, countArray.size())
                .filter(i -> countArray.get(i) == maxNumber)
                .boxed()
                .toList();

        List<String> finalWinner = result.stream()
                .map(i -> userArray.get(i).getName())
                .toList(); // 가장 큰 값이 있는 자동차(들) 출력

        String lastString = String.join(", ", finalWinner);

        System.out.println("최종 우승자 : " + lastString);
    }
}