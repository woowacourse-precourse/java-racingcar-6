package racingcar;

public class IntegrityCheck {
    public boolean nameIntegrityCheck(String name){
        if (name.length() > 5 || name.length() == 0){
            return true;
        }
        for (int i = 0; i < name.length(); i++){
            if ((name.charAt(i) <= 8) || (14 <= name.charAt(i) && name.charAt(i) <= 31)){
                return true;
            }
        }

        return false;
    }

    public boolean intIntegrityCheck(String str){
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) < '0' || '9' < str.charAt(i)){
                return true;
            }
        }
        return false;
    }
}
