package com.backend.service.impl;

import com.backend.service.UserService;
import com.backend.dto.user.User;
import com.backend.dao.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao dao;

    @Override
    public void save(User c) {
        dao.save(c);
    }

    @Override
    public void delete(String uid) {
        dao.delete(uid);
    }

    @Override
    public User findByUid(String uid) {
        return dao.findByUid(uid);
    }

    @Override
    public User findByEmail(String email) {
        return dao.findByEmail(email);
    }

    @Override
    public void update(User c) {
        dao.update(c);
    }

    @Override
    public void updateprofileImage(String nickname, String url) {
        dao.updateprofileImage(nickname, url);
    }

    @Override
    public void updateQRImage(String nickname, String url) {
        dao.updateQRImage(nickname, url);
    }

    @Override
    public User signin(String email, String password) {
        // 이메일과 패스워드 DB와 비교.
        User user = dao.signin(email, password);

        if (user != null) {
            return dao.signin(email, password);
        } else {
            throw new RuntimeException("그런 사람은 없어요.");
        }
    }

}