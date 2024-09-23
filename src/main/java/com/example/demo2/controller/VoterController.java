package com.example.demo2.controller;
import com.example.demo2.model.Voter;
import com.example.demo2.service.IVoterService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("votes")
public class VoterController
{
    private final IVoterService iVoterService;

    public VoterController(IVoterService iVoterService) {
        this.iVoterService = iVoterService;
    }

    @GetMapping("{id}")
    public ResponseEntity<Voter> getVoter(@PathVariable Integer id)
    {
        return ResponseEntity.ok(iVoterService.getVoter(id));
    }

    @GetMapping("all")
    public ResponseEntity<List<Voter>> getAllVoters()
    {
        return ResponseEntity.ok(iVoterService.getAllVoters());
    }

    @PostMapping
    public ResponseEntity<String> createVoter(@RequestBody Voter voter)
    {
        return ResponseEntity.ok(iVoterService.createVoter(voter));
    }

    @PutMapping()
    public ResponseEntity<String> updateVoter(@RequestBody Voter voter)
    {
        return ResponseEntity.ok(iVoterService.updateVoter(voter));
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteVoter(@PathVariable Integer id)
    {
        return ResponseEntity.ok(iVoterService.deleteVoter(id));
    }
}
