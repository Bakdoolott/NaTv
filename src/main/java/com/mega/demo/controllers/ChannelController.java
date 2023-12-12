package com.mega.demo.controllers;

import com.mega.demo.models.dto.CreateChannelRequest;
import com.mega.demo.services.ChannelService;
import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/channel")
@Api(tags = "Channels")
@AllArgsConstructor
public class ChannelController {
    private final ChannelService channelService;
    @PostMapping("/create")
    ResponseEntity<?> create(@ModelAttribute CreateChannelRequest data){
        return ResponseEntity.ok(channelService.createChannel(data.getLogo(),data));
    }

    @PostMapping("/delete/{id}")
    ResponseEntity<?> deleteChannel(@PathVariable Long id){
        return ResponseEntity.ok(channelService.deleteChannel(id));
    }

    @GetMapping()
    ResponseEntity<?> getAll(@RequestParam int limit,@RequestParam int pageNum){
        return ResponseEntity.ok(channelService.getAllByPageNum(limit,pageNum));
    }
}