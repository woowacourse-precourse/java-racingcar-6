package racingcar.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import racingcar.model.Car;


public class Util {
    public List<String> splitStringToList(String cars) {
        return new ArrayList<>(Arrays.asList(cars.split(",")));
    }

    public static int getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public static String getDash(int position)
    {
        String dash ="";
        for(int i=0; i<position ;i++){
            dash +="-";
        }
        return dash;
    }

    private int getPositionMax(List<Car> carList){
        return  carList.stream().mapToInt(Car::getPosition).max().getAsInt();
    }


    private void appendCommaIfNotEmpty(StringBuilder winners)
    {
        if (winners.length() > 0) {
            winners.append(", ");
        }
    }

    private void appendWinnerIfMaxPosition(Car car, int maxPosition, StringBuilder winners)
    {
        if (car.getPosition() == maxPosition) {
            appendCommaIfNotEmpty(winners);
            winners.append(car.getNAME());
        }
    }
    public String getWinner (List<Car> carList){
        int maxPosition = getPositionMax(carList);
        StringBuilder winners = new StringBuilder();
        for (Car car : carList) {
            appendWinnerIfMaxPosition(car, maxPosition, winners);
        }
        return winners.toString();
    }
}
