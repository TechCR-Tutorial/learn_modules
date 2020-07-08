package design.solution;

public abstract class Channel implements UserValidator {

    private int id;
    private String name;

    public Channel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    abstract void play();

    public UserValidator getValidator() {
        return this;
    }
;
}
