package logback;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import logback.level.UserLevel;
import logback.level2.HtmlLogger;

public class LogBackLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(LogBackLogger.class);

    public static void main(String[] args) throws InterruptedException {
        int a = 5;
        int b = 5;
        int result = a + b;
        LOGGER.debug("Result is : " + result);

        UserLevel userLevel = new UserLevel();
        userLevel.getUserRoleLevelInfo("ADMIN");
        userLevel.getUserRoleLevelInfo("READER");

        HtmlLogger.testHtmlLog();

        System.out.println(new Date());
        for (int i = 0; i < 10; i++) {
            Thread.sleep(6000);
            System.out.println("..");
            LOGGER.info("Test Rescan html2");
        }
        System.out.println(new Date());
    }
}
