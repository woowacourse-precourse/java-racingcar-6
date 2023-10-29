package racingcar;

import java.util.List;

public class SaveStopAndGo {

    List<Integer> saveStopAndGo(List<Integer> racingCarScore) {


        for (int i = 0; i < racingCarScore.size(); i++) {
            JudgeStopAndGo judge = new JudgeStopAndGo();
            if (judge.judgeStopAndGo() == true) {
                racingCarScore.set(i, racingCarScore.get(i) + 1);
            }
        }

        return racingCarScore;
    }
}
