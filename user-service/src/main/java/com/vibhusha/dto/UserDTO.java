package com.vibhusha.dto;

import com.vibhusha.model.UserRole;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {

    private String userName;
    private String password;
    private String token;
    private String avatar;
    private Date createdAt;
    private UserRole role;
    private Long reviewId;


}