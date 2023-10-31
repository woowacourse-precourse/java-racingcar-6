package racingcar;

import java.util.List;

public class Output {
    public void printRoundResult(List<Car> cars) {
        cars.forEach(car -> {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(car.getCarName());
            stringBuilder.append(" : ");
            for (int i = 0; i < car.getPosition(); i++) {
                stringBuilder.append("-");
            }
            System.out.println(stringBuilder.toString());
        });
    }

    public void printGameResult(List<Car> winnerList) {
        List<String> winnerNames = winnerList.stream().map(car -> car.getCarName()).toList();
        System.out.print("최종 우승자 : ");
        System.out.println(String.join(", ", winnerNames));
    }
}
