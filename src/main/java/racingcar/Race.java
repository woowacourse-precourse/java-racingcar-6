package racingcar;

public class Race {
    public void race(){
        RacingInfo racingInfo = new RacingInfo();
        PlayResult playResult = new PlayResult();

        racingInfo.setNamesAndNum();
        int num = racingInfo.getNum();
        String[] names = racingInfo.getNames();

        String[] results = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            results[i] = names[i] + " : ";
        }

        for (int i = 0; i < num; i++) {
            playResult.getResult(racingInfo.getNames(), results);
        }
    }
}
