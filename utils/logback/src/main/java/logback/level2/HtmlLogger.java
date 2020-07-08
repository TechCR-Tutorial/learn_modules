package logback.level2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HtmlLogger {

    private static final Logger LOGGER = LoggerFactory.getLogger(HtmlLogger.class);

    public static void testHtmlLog() {
        LOGGER.debug("HTML Message");
        LOGGER.info("HTML2 Message");
    }

}
