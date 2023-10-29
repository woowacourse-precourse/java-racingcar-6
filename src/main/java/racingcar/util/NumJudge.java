package racingcar.util;
import racingcar.util.RaceNumGenerator;
public class NumJudge {
    RaceNumGenerator raceNumGenerator = new RaceNumGenerator();
    public boolean judgeNum(){
        int randomNum = raceNumGenerator.generateNumber();
        return randomNum >= 4;
    }
}
