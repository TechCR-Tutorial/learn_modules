package design.solution;

public class TVService {

    public void selectChannel(User user, int channelId) {
        Channel chanel = findChannelById(channelId);
        if (chanel.getValidator().validate(user)) {
            chanel.play();
        }
    }

    private Channel findChannelById(int channelId) {
        //return find by id.
        return null;
    }
}
