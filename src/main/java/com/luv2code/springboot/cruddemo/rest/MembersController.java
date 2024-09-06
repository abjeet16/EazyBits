package com.luv2code.springboot.cruddemo.rest;
import com.luv2code.springboot.cruddemo.dao.MembersRepository;
import com.luv2code.springboot.cruddemo.entity.Members;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/members")
public class MembersController {

    @Autowired
    private MembersRepository membersRepository;

    // Get all members
    @GetMapping
    public List<Members> getAllMembers() {
        return membersRepository.findAll();
    }

    // Get a member by user_id
    @GetMapping("/{userId}")
    public ResponseEntity<Members> getMemberById(@PathVariable String userId) {
        Optional<Members> member = membersRepository.findById(userId);
        if (member.isPresent()) {
            return ResponseEntity.ok(member.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add a new member
    @PostMapping
    public ResponseEntity<Members> addMember(@RequestBody Members newMember) {
        if (membersRepository.existsByUserId(newMember.getUserId())) {
            return ResponseEntity.badRequest().body(null); // User already exists
        }
        newMember.setPw("{noop}"+newMember.getPw());
        Members savedMember = membersRepository.save(newMember);
        return ResponseEntity.ok(savedMember);
    }

    // Update a member
    @PutMapping("/{userId}")
    public ResponseEntity<Members> updateMember(@PathVariable String userId, @RequestBody Members updatedMember) {
        if (membersRepository.existsById(userId)) {
            updatedMember.setUserId(userId);
            Members savedMember = membersRepository.save(updatedMember);
            return ResponseEntity.ok(savedMember);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a member
    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> deleteMember(@PathVariable String userId) {
        if (membersRepository.existsById(userId)) {
            membersRepository.deleteById(userId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

