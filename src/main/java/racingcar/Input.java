package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Collection;

public class Input {
   public String[] inputCars() {
       String input = Console.readLine();
       String[] carArray = input.split(",");
       return carArray;
   }

}
