package racingcar;
import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.Console;
public class Game {
    Car[] Cars;
    String randomNumber;
    String nameLine;
    String[] names;

    void getNames(){
        nameLine = Console.readLine();
        Error.isNameError(nameLine);
        nameLine = nameLine.trim();
        names = nameLine.split(",");
    }

    void getNumber(){
        randomNumber = Console
    }

    Game(){
        getNames();
        getNumber();

    }
}
