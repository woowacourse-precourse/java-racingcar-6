package config;

import java.io.FileInputStream;
import java.util.Properties;

public class GameProperty {

    private final static Properties properties = new Properties();

    static {
        try {
            FileInputStream propertyFile = new FileInputStream("src/main/resources/gameCondition.properties");
            properties.load(propertyFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final static String CARNAME_REG_CONDITION = (String) properties.get("CARNAME.REG.CONDITION");

    private final static int MIN_RANDOM_RANGE = Integer.parseInt((String) properties.get("MIN.RANDOM.RANGE"));
    private final static int MAX_RANDOM_RANGE = Integer.parseInt((String) properties.get("MAX.RANDOM.RANGE"));
    private final static int FOR_MOVE_NUMBER = Integer.parseInt((String) properties.get("FOR.MOVE.NUMBER"));

    private final static int MAX_GAME_TIMES = Integer.parseInt((String) properties.get("MAX.GAME.TIMES"));
    private final static int MIN_GAME_TIMES = Integer.parseInt((String) properties.get("MIN.GAME.TIMES"));


    public static String getCarnameRegCondition() {
        return CARNAME_REG_CONDITION;
    }

    public static int getMinMoveForRange() {
        return MIN_RANDOM_RANGE;
    }

    public static int getMaxRandomRange() {
        return MAX_RANDOM_RANGE;
    }

    public static int getForMoveNumber() {
        return FOR_MOVE_NUMBER;
    }

    public static int getMaxGameTimes() {
        return MAX_GAME_TIMES;
    }

    public static int getMinGameTimes() {
        return MIN_GAME_TIMES;
    }

}
