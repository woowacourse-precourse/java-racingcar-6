package racingcar;
import java.util.List;
public class Output {

    public static void printResultmessage(){
        System.out.println("실행결과");
    }

    public static void printRacingState(List<CarState> cars){
        // 리스트 안에 존재하는 차량의 이름과 현재 위치를 -로 출력
        cars.forEach(car -> System.out.println(car.getName() + " : " + "-".repeat(car.getMoveCount())));
        System.out.println();
    }


    // 제일 먼 거리 찾기
    // 제일 먼 거리와 같은 값을 갖는 차량의 이름을 출력한다.

    public static void printWinner(List<CarState> cars) {
        int winnerMoveDistance = RacingCar.findMostFartherDistance(cars);
        String winnerNames = RacingCar.getWinnerNames(cars, winnerMoveDistance);
        System.out.println("최종 우승자 : " + winnerNames);
    }


}
