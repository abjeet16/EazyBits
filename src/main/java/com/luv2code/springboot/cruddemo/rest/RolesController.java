package com.luv2code.springboot.cruddemo.rest;

import com.luv2code.springboot.cruddemo.dao.RolesRepository;
import com.luv2code.springboot.cruddemo.entity.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RolesController {

    @Autowired
    private RolesRepository rolesRepository;

    // Get all roles
    @GetMapping
    public List<Roles> getAllRoles() {
        return rolesRepository.findAll();
    }

    // Get a role by user_id and role
    @GetMapping("/{userId}/{role}")
    public ResponseEntity<Roles> getRoleByUserIdAndRole(@PathVariable String userId, @PathVariable String role) {
        Optional<Roles> roleEntity = rolesRepository.findAll().stream()
                .filter(r -> r.getUserId().equals(userId) && r.getRole().equals(role))
                .findFirst();
        if (roleEntity.isPresent()) {
            return ResponseEntity.ok(roleEntity.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Add a new role
    @PostMapping
    public ResponseEntity<Roles> addRole(@RequestBody Roles newRole) {
        if (rolesRepository.existsByUserIdAndRole(newRole.getUserId(), newRole.getRole())) {
            return ResponseEntity.badRequest().body(null); // Role already exists for the user
        }
        Roles savedRole = rolesRepository.save(newRole);
        return ResponseEntity.ok(savedRole);
    }

    // Update a role
    @PutMapping("/{userId}/{role}")
    public ResponseEntity<Roles> updateRole(@PathVariable String userId, @PathVariable String role, @RequestBody Roles updatedRole) {
        if (rolesRepository.existsByUserIdAndRole(userId, role)) {
            updatedRole.setUserId(userId);
            updatedRole.setRole(role);
            Roles savedRole = rolesRepository.save(updatedRole);
            return ResponseEntity.ok(savedRole);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a role
    @DeleteMapping("/{userId}/{role}")
    public ResponseEntity<Void> deleteRole(@PathVariable String userId, @PathVariable String role) {
        if (rolesRepository.existsByUserIdAndRole(userId, role)) {
            rolesRepository.deleteById(userId);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

