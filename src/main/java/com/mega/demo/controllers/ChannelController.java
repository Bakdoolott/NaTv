package com.mega.demo.controllers;

import com.mega.demo.models.dto.CreateChannelRequest;
import com.mega.demo.services.ChannelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/channel")
@Api(tags = "Channels")
@AllArgsConstructor
public class ChannelController {
    private final ChannelService channelService;

    @ApiOperation("Also channel")
    @PostMapping("/create")
    ResponseEntity<?> create(@RequestBody CreateChannelRequest request){
        return ResponseEntity.ok(channelService.createChannel(request));
    }

    @PostMapping("/delete/{id}")
    ResponseEntity<?> deleteChannel(@PathVariable Long id){
        return ResponseEntity.ok(channelService.deleteChannel(id));
    }
}