package com.semina.feign.portal.client.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MapData {

    private String key;
    private String value;

    @Builder
    public MapData(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
