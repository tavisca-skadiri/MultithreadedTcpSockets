package logs;
import java.util.logging.*;
public class ServerLogger {
    public static void infoDisplay(String info){
        LogManager logManager = LogManager.getLogManager();
        java.util.logging.Logger logger = logManager.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
        logger.log(Level.INFO, info);
    }
    public static void warningDisplay(String warning){
        LogManager logManager = LogManager.getLogManager();
        java.util.logging.Logger logger = logManager.getLogger(java.util.logging.Logger.GLOBAL_LOGGER_NAME);
        logger.log(Level.WARNING, warning);
    }
}