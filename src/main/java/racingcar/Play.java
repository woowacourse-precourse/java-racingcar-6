package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
public class Play {
    public static void printCurrentPositions(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            car.printPosition();
        }
    System.out.println();
}
    public static void playRound(List<Car> cars) {
        for (Car car : cars) {
            car.move(Randoms.pickNumberInRange(0, 9));
        }
        printCurrentPositions(cars);
    }


}
