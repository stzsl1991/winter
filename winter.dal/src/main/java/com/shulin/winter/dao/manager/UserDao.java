package com.shulin.winter.dao.manager;

import com.shulin.winter.dao.base.BaseDao;
import com.shulin.winter.dao.common.MyBatisRepository;
import com.shulin.winter.entity.manager.User;

@MyBatisRepository
public interface UserDao extends BaseDao<User> {

}
