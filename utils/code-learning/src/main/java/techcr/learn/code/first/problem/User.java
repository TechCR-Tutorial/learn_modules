package techcr.learn.code.first.problem;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class User {

    private String userId;
    private String email;
    private String address;
    private boolean enable;
}
