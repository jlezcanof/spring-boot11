package edu.lez.boot8java11;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.ComponentScan;
import lombok.extern.slf4j.Slf4j;

/**
 * App entry point.<br>
 * 
 * 
 * <br>
 * -
 */
@SpringBootApplication()
@ComponentScan(basePackages = { "edu.lez.boot8java11" })
@Slf4j
public class App implements CommandLineRunner {

  /** Cache manager. */
  @Autowired
  private CacheManager cacheManager;

  /**
   * Main.
   * 
   * @param args -
   */
  public static void main(String[] args) {
    log.info(Arrays.toString(args));
    SpringApplication.run(App.class, args);
  }

  /**
   * Let's explicit active cache manager.
   * 
   * @param args -
   * @throws Exception -
   */
  @Override
  public void run(String... args) throws Exception {
    log.info("Spring boot Java 11 is using cache manager " + this.cacheManager.getClass().getName());
  }

}
