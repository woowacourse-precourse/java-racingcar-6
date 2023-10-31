package racingcar.view;

import racingcar.model.Car;
import racingcar.model.CarList;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputView {
    public void askForAllCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void askForNumberOfRuns() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResultMessage() {
        System.out.println("\n실행 결과");
    }

    public void printRoundResult(CarList cars) {
        for (Car car : cars.getCars()) {
            printCarNameAndPosition(car);
        }
        System.out.println();
    }

    private void printCarNameAndPosition(Car car) {
        System.out.println(car.getName()+" : "+ showPositionWithDashes("-", car.getPosition()));
    }

    private String showPositionWithDashes(String str, int position) {
        return IntStream.range(0, position)
                .mapToObj(i -> "-")
                .collect(Collectors.joining());
    }

    public void printWinners(List<String> winnerNames) {
        int winnerCount = winnerNames.size();
        if(winnerCount >1){
            printMultipleWinnerName(winnerNames);
        }else{
            printSingleWinnerName(winnerNames);
        }
    }

    private void printSingleWinnerName(List<String> winnerNames) {
        System.out.println("최종 우승자 : "+winnerNames.get(0));
    }

    private void printMultipleWinnerName(List<String> winnerNames) {
        String joinWinnerNames = String.join(", ", winnerNames);
        System.out.println("최종 우승자 : "+joinWinnerNames);
    }


}
