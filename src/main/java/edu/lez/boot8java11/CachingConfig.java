package edu.lez.boot8java11;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;

/**
 * CachingConfig. <br>
 * <br>
 * https://www.baeldung.com/spring-boot-evict-cache<br>
 * https://www.baeldung.com/spring-cache-tutorial<br>
 * https://howtodoinjava.com/spring-boot2/spring-boot-cache-example/<br>
 * <br>
 * WARNING:<br>
 * Cache is POD specific, for shared cache google for: "how to create a shared cache on
 * openshift/jvm in spring boot" and "how to integrate with a shared cache with spring boot".<br>
 * <br>
 * "@EnableCaching" enables spring caching for annotation "@Cacheable", etc. (remove this annotation
 * if issues with cache arise).<br>
 * <br>
 * <br>
 * ================================================================================================
 * <br>
 * **** Hazelcast ****<br>
 * Reference Manual > https://hazelcast.org/documentation/<br>
 * Sample > https://memorynotfound.com/spring-boot-hazelcast-caching-example-configuration/<br>
 * <br>
 * Configuration > resources/hazelcast.xml<br>
 * <br>
 * pom.xml > spring-boot-starter-cache, hazelcast and hazelcast-spring <br>
 * ================================================================================================
 */
@Configuration
@EnableCaching
public class CachingConfig {


  /**
   * Constructor (default).
   */
  protected CachingConfig() {
    super();
  }

}
