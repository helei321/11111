package mybatisplus.demo.Run;

import lombok.SneakyThrows;

import java.time.LocalDateTime;

public class ImgThread implements Runnable {

    private Integer atlasId;
    private Integer id;

    public ImgThread(int id, Integer atlasId) {
        this.id = id;
        this.atlasId = atlasId;
    }

    @SneakyThrows
    @Override
    public void run() {
        Thread.sleep(2000);
        System.out.println(Thread.currentThread().getName() + ",j=" + atlasId + "......" + LocalDateTime.now());


    }


}
