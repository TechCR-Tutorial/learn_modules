package design.second;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public void validate(User user, Channel requstChannel) {
        for (Channel channel : getChannels()) {
            if (channel.equals(requstChannel)) {
                validateChannel(user, channel);
            }
        }
    }

    private void validateChannel(User user, Channel channel) {
        String chanelCategory = channel.getCategory();
        if (user.getAge() < 18 && (chanelCategory.equals("CHILD") || chanelCategory.equals("ALL"))) {
            // list all the channels with channel category = CHILD and ALL
            System.out.println(channel.getChannelName());
        } else if (user.getAge() > 18 && user.getAge() < 45 && (chanelCategory.equals("ADULT")
                || chanelCategory.equals("ALL"))) {
            // list all the channels with channel category = ADULT and ALL
            System.out.println(channel.getChannelName());
        } else if (user.getAge() > 45 && (chanelCategory.equals("ADULT") || chanelCategory.equals("ALL"))) {
            // list all the channels with channel category = ELDER and ALL
            System.out.println(channel.getChannelName());
        }
    }

    private List<Channel> getChannels() {
        return new ArrayList<>();
    }
}
