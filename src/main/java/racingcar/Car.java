package racingcar;

public class Car {
    private static final int MIN_NAME_LENGTH = 1;
    private static final int MAX_NAME_LENGTH = 5;
    private static final int GO_STOP_STANDARD_NUMBER = 4;
    private static final String LOCATION_STRING = "-";
    
    public String name;
    public int location;
    public boolean isWinner;
    
    public Car(String name) {
        if (!isValidName(name)) {
            throw new IllegalArgumentException("Car name is not valid.");
        }
        this.name = name;
    }
    
    public void go(int randomNumber) {
        if (randomNumber >= GO_STOP_STANDARD_NUMBER) {
            this.location++;
        }
    }
    
    public void setWinner() {
        isWinner = true;
    }
    
    public String getLocationStatus() {
        return LOCATION_STRING.repeat(this.location);
    }
    
    private boolean isValidName(String name) {
        return checkValidNameLength(name) && !isBlankName(name);
    }
    
    private boolean checkValidNameLength(String name) {
        int nameLength = name.length();
        return nameLength >= MIN_NAME_LENGTH && nameLength <= MAX_NAME_LENGTH;
    }
    
    // 빈 문자열 혹은 공백 문자로 구성된 이름인지 판별하는 메서드
    private boolean isBlankName(String name) {
        return name.isBlank();
    }
}
