package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class TrialInput {
    public static int inputTrial() {
        String trialString = readLine();
        TrialValidation trialValidation = new TrialValidation();
        trialValidation.isValid(trialString);
        return Integer.parseInt(trialString);
    }
}
