package racingcar;

public class Extention {
    
    static Extention modify = new Extention();
    
    private Extention() {
    }
    
    public String removeSpace(String name) {
        if (!name.contains(" ")) {
            return name;
        }
        return name.replace(" ", "");
    }

    public void removeLastComma(StringBuilder sentence) {
        sentence.delete(sentence.length() - 2, sentence.length());
    }
}
