package racingcar;

public class Race {
    // 자동차 경주 플레이하는 함수
    public void race(){
        PlayResult playResult = new PlayResult();

        RacingInfo.setNamesAndNum();
        int num = RacingInfo.getNum();
        String[] names = RacingInfo.getNames();

        // 실행 결과 출력을 위한 "차량이름 : "이 담긴 배열 생성
        String[] results = getNameListofResults(names);

        // 실행 횟수 만큼 실행 결과 출력
        for (int i = 0; i < num; i++) {
            playResult.getResult(RacingInfo.getNames(), results);
        }
        playResult.getWinner(results);
    }

    // 실행 결과 출력을 위한 "차량이름 : "이 담긴 배열 생성 메소드
    public String[] getNameListofResults(String[] names){
        String[] results = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            results[i] = names[i] + " : ";
        }
        return results;
    }
}
