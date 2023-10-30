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

    private final static int MAX_CARNAME_LENGTH = Integer.parseInt((String) properties.get("MAX.CARNAME.LENGTH"));
    private final static int MIN_CARNAME_LENGTH = Integer.parseInt((String) properties.get("MIN.CARNAME.LENGTH"));
    private final static String CARNAME_REG_CONDITION = (String) properties.get("CARNAME.REG.CONDITION");

    private final static int MIN_RANDOM_RANGE = Integer.parseInt((String) properties.get("MIN.RANDOM.RANGE"));
    private final static int MAX_RANDOM_RANGE = Integer.parseInt((String) properties.get("MAX.RANDOM.RANGE"));
    private final static int FOR_MOVE_NUMBER = Integer.parseInt((String) properties.get("FOR.MOVE.NUMBER"));


    public static int getMaxCarnameLength() {
        return MAX_CARNAME_LENGTH;
    }

    public static int getMinCarnameLength() {
        return MIN_CARNAME_LENGTH;
    }

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

}
