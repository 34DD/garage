package com.garage.dto;

import lombok.*;
import java.util.*;

@Getter
@Setter
@AllArgsConstructor

public class AuthRequest {
    private String username;
    private String password;
}