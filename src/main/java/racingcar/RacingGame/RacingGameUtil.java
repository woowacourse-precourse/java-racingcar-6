package racingcar.RacingGame;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingGameUtil { // 출력 부분의 기능을 적는 곳

    Map<String, Integer> UserStatus = new HashMap<>(); // 회차마다의 경주 상태

    public Map<String, Integer> getUserStatus() {
        return UserStatus;
    }

    public void setUserStatus(Map<String, Integer> userStatus) {
        UserStatus = userStatus;
    }

    ///////////////////////////////////////////////////////////////////////////////////////

    public RacingGameUtil(List<String> userList){
        for (String user : userList)
            this.UserStatus.put(user, 0);
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    public void UpdateUserStatus(){ // 회차별 경주 상태 업데이트
        for(Map.Entry<String, Integer> userStatus : this.UserStatus.entrySet()){
            UpdateEachUserStatus(userStatus);
        }
    }

    public void PrintGameStatus(){ // 회차별 경주 상태 출력
        for(Map.Entry<String, Integer> entry : this.UserStatus.entrySet())
            // result: pobi : -
            System.out.println(entry.getKey() + " : " + "-".repeat(entry.getValue()));
        System.out.println("");
    }

    /////////////////////////////////////////////////////////////////////////////////////////////

    public int getWinnerRecord(){ // 게임에서 최대값을 가져옴
        int winnerRecord = 0;

        for(Map.Entry<String, Integer> userRecord : this.UserStatus.entrySet()){
            winnerRecord = UpdateWinnerRecord(winnerRecord, userRecord.getValue());
        }

        return winnerRecord;
    }

    public List<String> getWinnerList(int highRecord){
        List<String> winnerList = new ArrayList<>();

        for(Map.Entry<String, Integer> userRecord : this.UserStatus.entrySet()){
            addHighScoreUser(winnerList, userRecord, highRecord);
        }

        return winnerList;
    }

    public void UpdateEachUserStatus(Map.Entry<String, Integer> entry){
        if(Randoms.pickNumberInRange(0,9) >= 4) // 랜덤값이 4이상이면 유저 + 1
            entry.setValue(entry.getValue() + 1);
    }

    public int UpdateWinnerRecord(int winnerRecord, int userRecord){
        if(winnerRecord > userRecord)
            return winnerRecord;
        else
            return userRecord;
    }

    public boolean isHighScore(Map.Entry<String, Integer> userRecord, int highRecord){
        if(userRecord.getValue() == highRecord)
            return true;
        else
            return false;
    }

    public List<String> addHighScoreUser(List<String> beforeList,
                                         Map.Entry<String, Integer> userRecord, int highRecord){

        List<String> afterList = beforeList;

        if(isHighScore(userRecord, highRecord))
            beforeList.add(userRecord.getKey());

        return afterList;
    }

    public void checkUserNameLength(List<String> userList, GameExceptionUtil gameExceptionUtil){
        // User이름 체크.
        for(String user : userList){ // 유저이름 오류 체크
            gameExceptionUtil.checkUserNameLength(user);
        }
    }


}
