package com.mega.demo.models.dto;

import java.util.List;


public interface ChannelDetailsResponse {
    Long getId();
    String getLogo();
    String getName();
    Double getPrice();
    List<DiscountResponse> getDiscounts();

}
