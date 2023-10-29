package config;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
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

    private final static int MAX_CARNAME_LENGTH = (Integer) properties.get("MAX.CARNAME.LENGTH");
    private final static int MIN_CARNAME_LENGTH = (Integer) properties.get("MIN.CARNAME.LENGTH");
    private final static String REG_CARNAME = (String) properties.get("CARNAME.CONDITION");

    private final static int MIN_MOVE_FOR_RANGE = (Integer) properties.get("MIN.RANDOM.RANGE");
    private final static int MAX_MOVE_FOR_RANGE = (Integer) properties.get("MAX.RANDOM.RANGE");
    private final static int FOR_MOVE_NUMBER = (Integer) properties.get("FOR.MOVE.NUMBER");

    public static Map<String, Object> getCarNameCondition() {
        Map<String, Object> carNameCondition = new HashMap<>();

        carNameCondition.put("MAX_LENGTH", MAX_CARNAME_LENGTH);
        carNameCondition.put("MIN_LENGTH", MIN_CARNAME_LENGTH);
        carNameCondition.put("REG_CARNAME", REG_CARNAME);

        return carNameCondition;
    }

    public static Map<String, Object> getRandomNumberCondition() {
        Map<String, Object> randomNumberCondition = new HashMap<>();
        randomNumberCondition.put("MIN_NUM", MIN_MOVE_FOR_RANGE);
        randomNumberCondition.put("MAX_NUM", MAX_MOVE_FOR_RANGE);
        randomNumberCondition.put("MOVE_NUM", FOR_MOVE_NUMBER);
        return randomNumberCondition;
    }
}
