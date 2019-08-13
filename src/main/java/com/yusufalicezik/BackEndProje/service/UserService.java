package com.yusufalicezik.BackEndProje.service;

import com.yusufalicezik.BackEndProje.Entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    public User save(User user);
    public User getById(Long id);
    public Page<User> getAllPageable(Pageable pageable);
    public Boolean delete(User user);
    public User getByUsername(String username);

}
