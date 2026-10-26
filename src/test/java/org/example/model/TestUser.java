package org.example.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TestUser {

    private String email;
    private String password;
    private String accessToken;
    private Integer id;
    private String listingTitle;
    private String listingCategory;
}