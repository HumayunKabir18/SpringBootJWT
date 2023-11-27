package com.security.springbootjwt.Dao;
import org.springframework.stereotype.Component;

import lombok.*;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Component
public class JwtResponse {
    private String jwtToken;
    private String username;
}
