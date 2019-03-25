package top.myjnxj.web.task;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import top.myjnxj.entity.Photo;
import top.myjnxj.mapper.PhotoMapper;
import top.myjnxj.util.HippopxPageProcessor;

import java.util.List;

/**
 * @ClassName PhotoSchuduler
 * @Description TODO
 * @Author JNXJ
 * @Date 2019-03-25 11:22
 * @Version 1.0.0
 **/
@Component
@Slf4j
public class PhotoSchuduler {
    @Autowired
    private PhotoMapper photoMapper;

    @Scheduled(fixedDelay = 60000*60*24*15)
    public void photoSchuduler() throws InterruptedException {
        Thread.sleep(1000);
        log.info("执行爬取图片的任务");
        HippopxPageProcessor hippopxPageProcessor = new HippopxPageProcessor();
        List<Photo> photos = hippopxPageProcessor.listPhoto();
        try {
            log.info("insert photo {}",photoMapper.insertList(photos));
        } catch (Exception e) {
            log.info(e.toString());
        }
        log.info("end");
    }
}
