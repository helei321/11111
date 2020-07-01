package mybatisplus.demo.Controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import mybatisplus.demo.Run.ImgThread;
import mybatisplus.demo.entity.UserEntity;
import mybatisplus.demo.Service.UserServiceImpl;
import mybatisplus.demo.entity.userAtas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
@RequestMapping("Website")
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Resource
    ThreadPoolExecutor executor;
    @RequestMapping(value = "SelectUser", method = RequestMethod.POST)//查询
    public IPage<UserEntity> SelectUser(Integer pageSize,Integer pageNumber) {
        return userService.SelectUser(pageSize,pageNumber);
    }
    @RequestMapping(value = "SelectUser1", method = RequestMethod.POST)//查询
    public IPage<UserEntity> SelectUser1() {
        return userService.SelectUser1();
    }
    @RequestMapping(value = "addUser", method = RequestMethod.POST)//添加
    public void addUser() {
        userService.addUser();
    }

    @PostMapping("updateUser")
    public void updateUser() {
        userService.updateUser();
    }
    @PostMapping("delUser")
    public void delUser() {
        userService.delUser();
    }

    @PostMapping("selectUserAtlas")
    public List<userAtas> selectUserAtlas() {
       return userService.selectUserAtlas();
    }

    @PostMapping("aaa")
    public void aaa() {
        for (int i = 0; i < 100; i++) {
            ImgThread imgThread=new ImgThread(i,i);
           // ImgThread imgThread1=new ImgThread(222,3333);
            executor.execute(imgThread);
           // executor.execute(imgThread1);
        }
    }
}
