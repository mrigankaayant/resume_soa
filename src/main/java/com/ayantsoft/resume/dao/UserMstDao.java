package com.ayantsoft.resume.dao;

import com.ayantsoft.resume.pojo.UserMst;

public interface UserMstDao {
    UserMst getUserMstByUsername(String userName);
}