package techcr.learn.code.first.problem;

import java.io.IOException;

public class CodeLearningExampleOne {

    private PostServer postServer;
    private PostDao postDao;

    public void postingUser(User user) {
        String userInfo = user.toString();
        if (user.isEnable()) {
            postToServer(userInfo);
        }
    }

    public void postingEmployee(Employee employee) {
        String employeeInfo = employee.toString();
        if (employee.isEnable()) {
            postToServer(employeeInfo);
        }
    }

    public void postToServer(String postedInfo) {
        if (isPostServerEnable() && !postedInfo.isEmpty()) {
            /*
            Post the info message to remote info server.
            expecting HTTP status codes based on operation status.
             */
            try {
                postServer.post(postedInfo);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        postDao.savePost(postedInfo);

    }

    private boolean isPostServerEnable() {
        String postServerStatus = System.getProperty("post_server_enable");
        return "true".equals(postServerStatus);
    }

}
