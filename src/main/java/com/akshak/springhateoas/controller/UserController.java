package com.akshak.springhateoas.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.akshak.springhateoas.Model.User;
//import com.akshak.springhateoas.service.UserService;
import com.akshak.springhateoas.service.UserService;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;

import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.hateoas.Link;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;


@RestController
@RequestMapping("/users")
public class UserController {

    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {""}, produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<CollectionModel<EntityModel<User>>> findAll() {
    
        List<EntityModel<User>> users = userService.getAllUsers().stream()
        .map(user -> {
            if(user.isActive()){
                return new EntityModel<>(user, 
                linkTo(methodOn(UserController.class).findOne(user.getId())).withRel("details"));
            } else {
                return new EntityModel<User>(user, new Link[]{});
            }
        }) 
        .collect(Collectors.toList());
        
		return ResponseEntity.ok( 
				new CollectionModel<>(users, 
						linkTo(methodOn(UserController.class).findAll()).withSelfRel()));
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<EntityModel<User>>  findOne(@PathVariable Long id) {
        return Optional.of(userService.getUser(id))
        .map(user -> new EntityModel<>(user, 
            linkTo(methodOn(UserController.class).findAll()).withRel("back_to_all")))
        .map(ResponseEntity::ok) 
        .orElse(ResponseEntity.notFound().build());
            
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<CollectionModel<EntityModel<User>>> deleteser(@PathVariable Long id) {
    
        List<EntityModel<User>> users = userService.deleteUser(id).stream()
        .map(user -> {
            if(user.isActive()){
                return new EntityModel<>(user, 
                linkTo(methodOn(UserController.class).findOne(user.getId())).withRel("details"));
            } else {
                return new EntityModel<User>(user, new Link[]{});
            }
        }) 
        .collect(Collectors.toList());

		return ResponseEntity.ok( 
				new CollectionModel<>(users, 
						linkTo(methodOn(UserController.class).findAll()).withSelfRel()));
    }
}