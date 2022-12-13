package com.nobrand.blogapi.request;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Setter
@Getter
@ToString
public class PostCreate {

    @NotBlank(message = "must not be blank")
    private String title;
    @NotNull(message = "must not be null")
    private String content;

}
