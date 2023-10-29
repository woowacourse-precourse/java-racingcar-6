package racingcar;

public class IntegrityCheck {
    public boolean nameIntegrityCheck(String name){
        if (name.length() > 5 || name.length() == 0){
            return false;
        }
        for (int i = 0; i < name.length(); i++){
            if ((name.charAt(i) <= 8) && (14 <= name.charAt(i) && name.charAt(i) <= 31)){
                return false;
            }
        }

        return true;
    }
}
