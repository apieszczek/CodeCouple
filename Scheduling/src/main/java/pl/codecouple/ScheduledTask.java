package pl.codecouple;

import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.util.logging.Logger;


public class ScheduledTask {

    private final static Logger LOGGER = Logger.getLogger(ScheduledTask.class.getName());

    @Scheduled(fixedRate=5000)
    public void executeTask(){
        LOGGER.info("Task executed at " + LocalDateTime.now());
    }

}
