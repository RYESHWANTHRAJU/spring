package com.example.demo2.service;

import com.example.demo2.model.Voter;

import java.util.List;
import java.util.Optional;

public interface IVoterService
{
    Voter getVoter(Integer id);
    List<Voter> getAllVoters();
    String createVoter(Voter voter);
    String updateVoter(Voter voter);
    String deleteVoter(Integer id);
}
