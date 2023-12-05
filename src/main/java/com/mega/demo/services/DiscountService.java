package com.mega.demo.services;

import com.mega.demo.models.dto.CreateDiscountRequest;
import com.mega.demo.models.dto.Response;
import com.mega.demo.models.dto.entityDto.DiscountDto;

public interface DiscountService {
    DiscountDto save(DiscountDto discountDto);
    DiscountDto findById(Long id);

    Response deleteDiscount(Long discountId);
    Response createDiscount(CreateDiscountRequest request);
}
