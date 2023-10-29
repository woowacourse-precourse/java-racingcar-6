package racingcar.model;

import racingcar.controller.TakeInputs;

import java.util.List;

public class RacingData {

    private static RacingData instance;
    private RacingData(){}
    public static RacingData getInstance() {
        if (instance == null) {
            instance = new RacingData();
        }
        return instance;
    }



    private static String userInputLoopString;
    private static String passedTestLoopString;
    private static int userSetLoopTime;
    private static List<Integer> forwardPointList;
    private static List<String> winnerList;



    public static String getUserInputLoopString() {
        return userInputLoopString;
    }

    public static void setUserInputLoopString(String userInputLoopString) {
        RacingData.userInputLoopString = userInputLoopString;
    }


    public static String getPassedTestLoopString() {
        return passedTestLoopString;
    }

    public static void setPassedTestLoopString(String passedTestLoopString) {
        RacingData.passedTestLoopString = passedTestLoopString;
    }


    public static int getUserSetLoopTime() {
        return userSetLoopTime;
    }
    public static void setUserSetLoopTime(int userSetLoopTime) {
        RacingData.userSetLoopTime = userSetLoopTime;
    }


    public List<Integer> getForwardPointList() {
        return forwardPointList;
    }

    public void setForwardPointList(List<Integer> forwardPoint) {
        forwardPointList = forwardPoint;
    }


    public static List<String> getWinnerList() {
        return winnerList;
    }

    public static void setWinnerList(List<String> winnerList) {
        RacingData.winnerList = winnerList;
    }

}





