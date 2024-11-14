package co.pragra.learning.resttemplatedemo.controller;

import co.pragra.learning.resttemplatedemo.dto.GitHubUser;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@Slf4j
public class GitController {
    private final RestTemplate restTemplate;

    @GetMapping("/users/{user}")
    public GitHubUser getGitHubUser(@PathVariable("user") String user, HttpServletRequest request) {
        Logger logger = LogManager.getLogger(GitController.class);

        log.info("***********This is Info Message***************");
        log.debug("***********This is Debug Message***************");
        log.error("***********This is Error Message***************");
        log.warn("***********This is Warn Message***************");
        log.trace("***********This is Trace Message***************");

        System.out.println("Here is the method: " + request.getMethod() + "Agent is: " + request.getHeader("User-Agent"));
        logger.info("Request method: {} and Agent is {}", request.getMethod(), request.getHeader("User-Agent"));

        GitHubUser gitUser = restTemplate.getForObject("https://api.github.com/users/" + user, GitHubUser.class);
        System.out.println("gitUser : " + gitUser);
        return gitUser;
    }

    @PostMapping("/users")
    public ResponseEntity<String> postRandom(){
        Request request = new Request();
        request.setFirstName("Testing");
        request.setLastName("Learning");
        request.setEmail("testing@pragra.io");
        request.setSubject("Java FS");
        request.setQuery("All good at our end!");

        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        HttpEntity<Request> requestEntity = new HttpEntity<>(request, headers);
        ResponseEntity<String> mapResponseEntity = restTemplate.postForEntity("https://app.pragra.io/api/engagement/contact", requestEntity, String.class);
        System.out.println("mapResponseEntity.getBody() : " + mapResponseEntity.getBody());
        return mapResponseEntity;
    }
}

@Data
class Request{
   private String firstName;
   private String lastName;
    private String email;
    private String subject;
    private String query;
}
