package com.project.voting_app.controller;

import com.project.voting_app.entity.Poll;
import com.project.voting_app.entity.Vote;
import com.project.voting_app.service.PollService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/polls")
@RequiredArgsConstructor
public class PollController {

    private final PollService pollService;

    @PostMapping("/create")
    public Poll createPoll(@RequestBody Poll poll) {
        return pollService.createPoll(poll);
    }

    @GetMapping("/get")
    public List<Poll> getAllPolls() {
        return pollService.getAllPolls();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Poll> getPollById(@PathVariable Long id) {
        return ResponseEntity.ok(pollService.getPollById(id).orElseThrow(() -> new RuntimeException("Poll not found with the given id " + id)));
    }

    @PostMapping("/vote")
    public void vote(@RequestBody Vote vote) {
        pollService.vote(vote.getPollId(), vote.getOptionIndex());
    }
}
