package constant;

public enum GameConfig {
    CAR_NAME(5, ",");

    private final int limitLength;
    private final String seperator;

    GameConfig(int limitLength, String seperator){
        this.limitLength = limitLength;
        this.seperator = seperator;
    }

    public int getLimitLength(){
        return this.limitLength;
    }

    public String getSeperator(){
        return this.seperator;
    }

}
