package racingcar.controller;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

/**
 * Judges whether the car can move or not
 *
 * @author WorldBestProgrammer
 */
public class JudgeMovement {

    /**
     * Gets int type random number between minNumber and maxNumber
     *
     * @param minNumber The minimum number
     * @param maxNumber The maximum number
     * @return Random number of int type between minNumber and maxNumber
     */
    public static int getRandomNumber(int minNumber, int maxNumber) {
        return pickNumberInRange(minNumber, maxNumber);
    }

    /**
     * Judges whether number is more than criteria
     *
     * @param randomNumber Number to be compared with criteria
     * @param criteria Criteria number
     * @return true if randomNumber is more than criteria, else false
     */
    public static boolean goFlag(int randomNumber, int criteria) {
        return randomNumber >= criteria;
    }
}
