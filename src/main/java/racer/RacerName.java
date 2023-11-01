package racer;

public class RacerName {
    
    String name;
    
    RacerName(String name) {
        if (name.length() < 1) {
            throw new IllegalArgumentException("이름은 1자 이상이어야 합니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
        String space = " ";
        if (name.contains(space)) {
            throw new IllegalArgumentException("이름에 공백은 포함되면 안됩니다.");
        }
        String tab = String.valueOf('\t');
        if (name.contains(tab)) {
            throw new IllegalArgumentException("이름에 공백은 포함되면 안됩니다.");
        }
        this.name = name;
    }
    
    public String getName() {
        return name;
    }

}
