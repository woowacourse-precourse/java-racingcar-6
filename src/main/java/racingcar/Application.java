package racingcar;


public class Application {
    private static GameRandom random;

    private static GameRandom getRandom(){
        if(random == null){
            random = new MissionUtilsGameRandom();
        }
        return random;
    }

    public static void setRandom(GameRandom newRandom){
        random = newRandom;
    }

    public static void main(String[] args) {
        GameExecutor gameExecutor = new GameExecutor();
        if (random == null) {
            random = new MissionUtilsGameRandom();
        }
        gameExecutor.run(getRandom());

    }
}
