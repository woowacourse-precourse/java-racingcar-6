package racingcar.view;

import java.util.List;

import racingcar.model.Car;
import racingcar.model.service.Race;
import racingcar.model.service.WinnerResponse;

public class OutputView {
    public void printRaceResult(final List<Car> cars) {
        for (Car car : cars) {
            String distance = "";
            for(int i=0; i<car.getDistance(); i++) {
                distance += "-";
            }
            System.out.println(String.format("%s : %s", car.getName(), distance));
        }
        System.out.println();
    }
    
    public void printWinner(final List<Car> cars) {
        WinnerResponse winnerResponse = Race.getWinner(cars);
        printRaceResultEnd();
        List<Car> winnerCars = winnerResponse.winnerCars();

        StringBuilder stringBuilder = new StringBuilder();
        for (Car car : winnerCars) {
            stringBuilder.append(String.format("%s, ", car.getName()));
        }
        stringBuilder.delete(stringBuilder.length()-2, stringBuilder.length());
        System.out.println(stringBuilder.toString());
    }

    public void printRaceResultStart() {
        System.out.println("실행 결과");
    }

    private void printRaceResultEnd() {
        System.out.print("최종 우승자 : ");
    }
}
