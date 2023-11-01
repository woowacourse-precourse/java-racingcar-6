package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static racingcar.Exceptions.nameListInputException;
import static racingcar.Exceptions.notInputNaturalNumberException;

public class Functions {

    public static String inputNames(){
        String list = Console.readLine();
        nameListInputException(list);
        return list;
    }

    public static List<String> splitName(){
        return Arrays.asList(inputNames().split(","));
    }

    public static Integer loopCount(){
        String loop = Console.readLine();
        notInputNaturalNumberException(loop);
        return Integer.parseInt(loop);
    }

    public static Integer getRandomNumber(){
        return Randoms.pickNumberInRange(0,9);
    }

    public static boolean checkDriving(Integer n){
        if (n >= 4) { return true; }
        else { return false; }
    }

    public static List<String> getWinner(List<Car> cars){
        if(cars.size() < 1) {
            throw new IllegalArgumentException();
        }
        List<String> winners = new ArrayList<String>();
        Integer winnerMileageSize = cars.get(0).getMileage().length();
        winners.add(cars.get(0).getName());

        for(int i = 1 ; i <cars.size(); i++){
            Integer compareOtherSize = cars.get(i).getMileage().length();
            if(winnerMileageSize <= compareOtherSize && winnerMileageSize.equals(compareOtherSize)){
                winners.add(cars.get(i).getName());
            } else if (winnerMileageSize < compareOtherSize){
                winners.clear();
                winnerMileageSize = compareOtherSize;
                winners.add(cars.get(i).getName());
            }

        }
        return winners;
    }
}
