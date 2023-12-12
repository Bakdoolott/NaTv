package com.mega.demo.models.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class ChannelResponse {
    Long totalCountOfChannels;
    List<ChannelDetailsResponse> resultList;
}
