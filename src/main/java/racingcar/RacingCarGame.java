package racingcar;

import java.util.ArrayList;
import java.util.List;
import static racingcar.Constant.*;

public class RacingCarGame {
    private int moveNumber;
    private List<Car> carList;
    private final User user = new User();

    public void start() {
        carList = user.getCarNames();
        moveNumber = user.getMoveNumber();

        System.out.print("\n" + RESULT_MSG);
        for (int i = 0; i < moveNumber; i++) {
            moveCars();
        }
        printFinishCarNames();
    }

    public void moveCars() {
        for (Car car : carList){
            car.move();
        }
        System.out.print("\n");
    }

    public void printFinishCarNames() {
        List<String> FinishCarNamesList = getFinishCarNames();
        String FinishCarNamesStr = String.join(", ", FinishCarNamesList);
        System.out.print(WINNER_MSG + FinishCarNamesStr);
    }

    public List<String> getFinishCarNames(){
        List<String> FinishCarNamesList = new ArrayList<>();
        int maxDistance = 0;
        for (Car car : carList){
            int currentDistance = car.getDistance();
            if (currentDistance > maxDistance){
                maxDistance = currentDistance;
                FinishCarNamesList.clear();
                FinishCarNamesList.add(car.getCarName());
            }else if (currentDistance == maxDistance){
                FinishCarNamesList.add(car.getCarName());
            }
        }
        return FinishCarNamesList;
    }
}
