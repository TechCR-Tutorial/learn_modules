package design.first;

public class LogicHandler {

    public boolean isAllow(User user, Channel chanel) {
        int age = user.getAge();
        ChannelCategory chanelCategory = chanel.getCategory();
        int limit = chanelCategory.getLimit();
        return (age < limit);
    }
}
