package mybatisplus.demo.Service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import mybatisplus.demo.entity.UserEntity;
import mybatisplus.demo.entity.userAtas;

import java.util.List;

public interface UserServiceImpl extends IService<UserEntity> {
    IPage<UserEntity> SelectUser(Integer pageSize,Integer pageNumber);

    void addUser();

    void updateUser();

    void delUser();

    IPage<UserEntity> SelectUser1();

    List<userAtas> selectUserAtlas();
}
