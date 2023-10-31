package valid;

public class ValidCheck {
    public void checkNameNoInput(String name) {
        if (name.equals("")) {
            throw new IllegalArgumentException();
        }

    }

    public void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException();
        }
    }

}
