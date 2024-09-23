package com.example.demo2.service;

import com.example.demo2.model.Voter;
import com.example.demo2.repository.VoterRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class IVoterServiceImpl implements IVoterService {
    private final VoterRepository voterRepository;
    List<Voter> voterList=new ArrayList<>();
    public IVoterServiceImpl(VoterRepository voterRepository) {
        this.voterRepository = voterRepository;
    }

    @Override
    public Voter getVoter(Integer id) {
        Optional<Voter> optionalVoter=voterRepository.findById(id);
        if(optionalVoter.isPresent())
        {
            return optionalVoter.get();
        }
        else
        {
            throw new RuntimeException("Voter not found with the given Id :"+id);
        }
    }

    @Override
    public List<Voter> getAllVoters() {
        return voterRepository.findAll();
    }

    @Override
    public String createVoter(Voter voter) {
        Voter voter1=new Voter(voter.getId(),voter.getName(),voter.getAge(),voter.getGender(),voter.getParty());
        voterRepository.save(voter1);
        return "Voter created successfully";
    }

    @Override
    public String updateVoter(Voter voter) {
        Optional<Voter> optionalVoter=voterRepository.findById(voter.getId());
        if(optionalVoter.isPresent())
        {
            Voter dbVoter=optionalVoter.get();
            dbVoter.setName(voter.getName());
            dbVoter.setAge(voter.getAge());
            dbVoter.setGender(voter.getGender());
            dbVoter.setParty(voter.getParty());
            voterRepository.save(dbVoter);
            return "Voter updated successfully";
        }
        else
        {
            throw new RuntimeException("Voter not found with the given Id :"+voter.getId());
        }
    }

    @Override
    public String deleteVoter(Integer id) {
        Optional<Voter> optionalVoter=voterRepository.findById(id);
        if(optionalVoter.isPresent())
        {
            Voter dbVoter=optionalVoter.get();
            voterRepository.delete(dbVoter);
            return "Voter deleted successfully";
        }
        else {
            throw new RuntimeException("Voter not found with the given Id :"+id);
        }
    }
}
