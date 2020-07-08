package design.solution;

public class CartoonChannel extends Channel {

    public CartoonChannel(int id, String name) {
        super(id, name);
    }

    @Override
    public boolean validate(User user) {
        return Catagory.CHILD.userPredicate().test(user);
    }

    @Override
    void play() {
        System.out.println("Playing cartoon channel...");
    }

}
