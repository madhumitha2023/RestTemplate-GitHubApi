package co.pragra.learning.resttemplatedemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class GitHubUser {
    private Long id;
    private String login;
    @JsonProperty("avatar_url")
    private String avatarUrl;
    private String name;
    private String company;
    @JsonProperty("public_repos")
    private String publicRepos;
}
