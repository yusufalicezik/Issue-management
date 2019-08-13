package com.yusufalicezik.BackEndProje.service.impl;


import com.yusufalicezik.BackEndProje.Entity.Project;
import com.yusufalicezik.BackEndProje.Entity.User;
import com.yusufalicezik.BackEndProje.repository.ProjectRepository;
import com.yusufalicezik.BackEndProje.repository.UserRepository;
import com.yusufalicezik.BackEndProje.service.ProjectService;
import com.yusufalicezik.BackEndProje.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        if(user.getEmail() == null) {
            throw new IllegalArgumentException("E mail boş olamaz");
        }
        user = userRepository.save(user);
        return user;
    }

    @Override
    public User getById(Long id) {
        return userRepository.getOne(id);
    }

    @Override
    public Page<User> getAllPageable(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Boolean delete(User user) {
        userRepository.delete(user);
        return Boolean.TRUE;
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
