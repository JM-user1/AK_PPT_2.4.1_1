package com.jm.crud.service;

import java.util.List;

import com.jm.crud.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jm.crud.entity.User;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

  private  UserRepository userRepository;


  @Autowired
  public UserServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  @Transactional
  public List<User> allUser() {
    return userRepository.findAll();
  }

  @Override
  @Transactional
  public void add(User user) {
    userRepository.saveAndFlush(user);
  }

  @Override
  public void delete(Long id) {
    userRepository.deleteById(id);
  }

  @Override
  @Transactional
  public void edit(Long id, User user) {
    User updatedUser = userRepository.getOne(id);
    updatedUser.setFirstName(user.getFirstName());
    updatedUser.setLastName(user.getLastName());
    updatedUser.setAge(user.getAge());
    userRepository.saveAndFlush(updatedUser);
  }

  @Override
  @Transactional
  public User getById(Long id) {
    User user = userRepository.getOne(id);
    System.out.println(user.getFirstName());
    return user;
  }
}
