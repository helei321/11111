package mybatisplus.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Configuration
@Slf4j
public class WebConfiguration implements WebMvcConfigurer {
    @Bean
    public ThreadPoolExecutor executorServices() {
        int cpuCoreNumber = Runtime.getRuntime().availableProcessors();
        System.out.println("cpuCoreNumber:" + cpuCoreNumber);
        BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<>(60);//线程等待队列
        ThreadPoolExecutor executor = new ThreadPoolExecutor(cpuCoreNumber * 2, 50, 60, TimeUnit.MILLISECONDS,
                workQueue);
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());//拒绝策略
        executor.prestartAllCoreThreads(); // 预启动所有核心线程
        return executor;
    }
}
