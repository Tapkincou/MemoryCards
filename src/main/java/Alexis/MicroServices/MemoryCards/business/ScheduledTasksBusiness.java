package Alexis.MicroServices.MemoryCards.business;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;


public class ScheduledTasksBusiness {

    @Component
    public static class ScheduledTasks {

        private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

        private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");


        //@Scheduled(fixedRate = 5000) // every 5 sec
        @Scheduled(cron = "0 1 5 * * ?") // every day at 5 pm
        public void reportCurrentTime() {
            // TODO: reduce card learninglevel
            log.info("The time is now {}", dateFormat.format(new Date()));
        }
    }

}
