package com.hackyeah.hy22.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VersionResponse {
    private String version;
}
