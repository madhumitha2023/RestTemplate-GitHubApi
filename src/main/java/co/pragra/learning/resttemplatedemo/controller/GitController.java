package co.pragra.learning.resttemplatedemo.controller;

import co.pragra.learning.resttemplatedemo.dto.GitHubUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequiredArgsConstructor
public class GitController {
    private final RestTemplate restTemplate;

    @GetMapping("/users/{user}")
    public GitHubUser getGitHubUser(@PathVariable("user") String user) {
        GitHubUser gitUser = restTemplate.getForObject("https://api.github.com/users/" + user, GitHubUser.class);
        System.out.println("gitUser : " + gitUser);
        return gitUser;
    }
}
