package racingcar;

import java.util.*;

public class SettingGame { //게임 진행 전 필요한 정보를 세팅합니다.
    private static IO io;
    private static CheckForm checkForm;
    private List<String> RunnerMap = new ArrayList<>(); //자동차의 이름을 나타냄
    private LinkedHashMap<String, String> GameInfoMap = new LinkedHashMap<>(); //각 자동차의 이름과 경주상태를 나타냄
    //순서가 보장되고, key-value를 이용해야 했기에 해당 자료구조를 선택했습니다.

    public SettingGame(IO io, CheckForm checkForm) {
        this.io = io;
        this.checkForm = checkForm;
    }

    public void setGame() {
        createRunnerMap();
        io.printNull();
        System.out.println("실행 결과");
    }

    private void createRunnerMap() { //사용자의 입력을 받아 RunnerMap 작성

        String runnerInput = io.start();
        StringTokenizer tokenizer = new StringTokenizer(runnerInput, ",");
        while (tokenizer.hasMoreTokens()) {
            String token = tokenizer.nextToken();
            checkForm.RunnerSize(token);
            RunnerMap.add(token);
        }

        for (String key : RunnerMap) {
            GameInfoMap.put(key, "");
        }
    }

    public List<String> getRunnerMap(){
        return RunnerMap;
    }

    public LinkedHashMap<String, String> getGameInfoMap(){
        return GameInfoMap;
    }

}

