package logback.level;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class UserLevel {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserLevel.class);

    public void getUserRoleLevelInfo(String role) {
        MDC.put("userRole", role);
        LOGGER.debug("{}", "Logging base on user role : " + role);
        MDC.put("userRole", null);
        LOGGER.debug("{}", "Logging 2 base on user role : " + role);
    }
}
