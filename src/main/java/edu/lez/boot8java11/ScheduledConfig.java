package edu.lez.boot8java11;

import java.util.Calendar;
import java.util.Date;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

/**
 * ScheduledConfig. <br>
 * <br>
 * a) It enables Spring’s scheduled task execution capability<br>
 * b) It schedules different general purpose jobs not already scheduled in their specific
 * configuration (as CachingConfig)<br>
 * <br>
 */
@EnableScheduling
@Configuration
@Slf4j
public class ScheduledConfig {

 

  /**
   * Once a day (no execution first day):<br>
   * -Remove old entries from table 'app_request'
   */
  @Scheduled(fixedDelay = 24 * 60 * 60 * 1000, initialDelay = 24 * 60 * 60 * 1000)
  public void appRequestClean() {
    log.info("INI Removing old entries from 'app_request', before: " );
    //
    final Calendar d15 = Calendar.getInstance();
    d15.add(Calendar.HOUR_OF_DAY, -128);
    Date oneHundredTwentyEightHoursAgo = d15.getTime();

    log.info("END Removing old entries from 'app_request', left: ");
  }

}
