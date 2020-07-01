package mybatisplus.demo.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import mybatisplus.demo.entity.UserEntity;
import mybatisplus.demo.entity.userAtas;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper extends BaseMapper<UserEntity> {
    @Select("select * from user_atlas ${ew.customSqlSegment}")
    List<userAtas> getAll(@Param(Constants.WRAPPER)QueryWrapper<Object> id);
}
