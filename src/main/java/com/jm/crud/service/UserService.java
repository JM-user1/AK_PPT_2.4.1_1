package com.jm.crud.service;

import java.util.List;

import com.jm.crud.entity.User;

public interface UserService {
  List<User> allUser();
  void add(User user);
  void delete(Long id);
  void edit( Long id, User user);
  User getById(Long id);

}
