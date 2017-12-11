package com.myblog.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.myblog.entity.UserEntity;
import com.myblog.mapper.UserMapper;
import com.myblog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YoungM25 on 2017/11/30.
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserEntity> implements UserService{

    @Autowired
    private UserMapper userMapper;


    /**
     * @CacheEvict 支持如下几个参数：
     *value：缓存位置名称，不能为空，同上
     *key：缓存的key，默认为空，同上
     *condition：触发条件，只有满足条件的情况才会清除缓存，默认为空，支持SpEL
     *allEntries：true表示清除value中的全部缓存，默认为false
     */
    /**
     * Cacheable
     * value：缓存位置名称，不能为空，如果使用EHCache，就是ehcache.xml中声明的cache的name
     * key：缓存的key，默认为空，既表示使用方法的参数类型及参数值作为key，支持SpEL
     * condition：触发条件，只有满足条件的情况才会加入缓存，默认为空，既表示全部都加入缓存，支持SpEL
     *
     * @return
     */
    @Cacheable(value = "user", key = "#root.targetClass+#username", unless = "#result eq null")
    public List<UserEntity> queryList() {
        return userMapper.queryList();
    }
    
    @Cacheable(value = "user", key = "#root.targetClass+#username", unless = "#result eq null")
    public UserEntity selectByOpenId(String opendId) {
    	UserEntity user = userMapper.selectByOpenId(opendId);
        return user;
    }

    @Override
    public UserEntity updateUserInfo(UserEntity user) {
        String openId = user.getOpenId();
        String avatar = user.getAvatar();
        avatar = avatar.replace("http:","");
        user.setAvatar(avatar);
        UserEntity origin = userMapper.selectByOpenId(openId);
        if (origin == null){
            // 首次登陆
            userMapper.insert(user);

        }else {
            // 再次登陆，信息与之前不一致，则更新
            String md5 = user.getMd5();
            String originMd5 = origin.getMd5();
            if (originMd5 != null && !md5.equals(originMd5)){
                userMapper.update(user,null);
            }
            user.setId(origin.getId());
        }
        return user;
    }

}
