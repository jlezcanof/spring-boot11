package edu.lez.boot8java11.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import io.swagger.annotations.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;

/**
 * <br>
 * ·Business UI > THIS FILE (mapped at '/ui') intended for operations to be consumed by the
 * Front-End (Angular UI)<br>
 * <br>
 * ·HTTP verbs used (general guideline, there are exceptions):<br>
 * -Reading_ > GET (by url) or PATCH (by body), though standard defines it for partial updates<br>
 * -Creating > POST<br>
 * -Updating > PUT, idempotent by definition<br>
 * -Deleting > DELETE<br>
 * <br>
 * ·List of HTTP status codes >
 * https://www.iana.org/assignments/http-status-codes/http-status-codes.xhtml<br>
 * https://en.wikipedia.org/wiki/List_of_HTTP_status_codes<br>
 */
@RequestMapping(path = "/ui", produces = MediaType.APPLICATION_JSON_VALUE)
@RestController
@Slf4j
@Tag(name = "contact", description = "the Contact API")
public class UiV1Controller {

 



  /**
   * .<br>
   * 
   * Initially invoked by the UI for bootstrapping the Angular app in the proper language, etc.
   * 
   * 
   * <br>
   * ==============<br>
   * 
   * 
   * 
   * 
   * 
   * @param headerXRequestedWith Ignored, no currently forwarded by API Gateway (CORS config)
   * @param oauthToken           Ignored, but must be valid when using the API Gateway
   * @param campusSessionId      Campus session id
   * 
   * @return User idp, displayName, langIanaCode and roles
   */
  @GetMapping(value = "/user/info")
  @ApiResponses(value = { // NOSONAR
      @ApiResponse(responseCode =  "200", description = "OK"), // NOSONAR
      @ApiResponse(responseCode = "400",
          description = "Bad request (one or more input arguments do not pass validation)"), // NOSONAR
      @ApiResponse(responseCode = "401",
          description = "Unauthenticated (user session isn't valid either in TREN)"), // NOSONAR
      @ApiResponse(responseCode = "403", description = "User might not have the necessary permissions"), // NOSONAR
      @ApiResponse(responseCode = "404",
          description = "The requested resource could not be found but may be available in the future"), // NOSONAR
      @ApiResponse(responseCode = "500", description = "An unexpected condition was encountered"), // NOSONAR
      @ApiResponse(responseCode = "503", description = "Service unavailable"), // NOSONAR
      @ApiResponse(responseCode = "504", description = "No timely response received from 3rd party system") // NOSONAR
  })
  public ResponseEntity<?> getUserInfo( // NOSONAR
      @RequestHeader(name = "X-Requested-With", required = false) String headerXRequestedWith, // NOSONAR
      @RequestHeader(name = "Authorization", required = true) @NonNull String oauthToken, // NOSONAR
      @RequestHeader(name = "X-Api-Key", required = true) @NonNull String campusSessionId // NOSONAR
  ) {
    // Initial /user/info (authorization must not be verified)
    try {
      // (·) Authentication

      return new ResponseEntity<>("user", HttpStatus.OK);
    } catch (Exception e) {
       log.error("error");
      return new ResponseEntity<>("error grave", HttpStatus.BAD_REQUEST);
    } /*catch (final Exception th) {
      return ExceptionHelper.newResponseEntityForThrowable(th, LangHelper.DEFAULT_IANA_CODE, log);
    }*/
    //
  } // getUserInfo()

}
