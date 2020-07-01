package mybatisplus.demo.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import mybatisplus.demo.entity.UserEntity;
import mybatisplus.demo.entity.userAtas;
import mybatisplus.demo.mapper.UserMapper;
import org.springframework.data.convert.EntityWriter;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserService extends ServiceImpl<UserMapper, UserEntity> implements UserServiceImpl {
    @Resource
    UserMapper userMapper;

    public IPage<UserEntity> SelectUser(Integer pageSize,Integer pageNumber) {
        return userMapper.selectPage(new Page<UserEntity>(1, 2),null);
    }

    @Override
    public void addUser() {
        UserEntity userEntity = new UserEntity();
        userEntity.setCreateTime(LocalDateTime.now());
        userEntity.setName("aaaaa");
        userEntity.setPassword("564564546");
        userMapper.insert(userEntity);
        System.out.println(userEntity.getId());
    }

    @Override
    public void updateUser() {

        UserEntity userEntity = new UserEntity();
       // userEntity.setId(1);
        userEntity.setName("22222222222");
       // userMapper.updateById(userEntity);
        userMapper.update(userEntity,new UpdateWrapper<UserEntity>().eq("password","5645645463"));
    }

    @Override
    public void delUser() {
        userMapper.deleteById(1);

    }

    @Override
    public IPage<UserEntity> SelectUser1() {
        return null;
    }

    @Override
    public List<userAtas> selectUserAtlas() {
        return userMapper.getAll(Wrappers.query().eq("id",2));

    }
}
