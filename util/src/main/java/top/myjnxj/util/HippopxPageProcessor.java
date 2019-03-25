package top.myjnxj.util;

import lombok.extern.slf4j.Slf4j;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import top.myjnxj.core.Spider;
import top.myjnxj.core.model.Page;
import top.myjnxj.core.model.Site;
import top.myjnxj.core.processor.PageProcessor;
import top.myjnxj.entity.Photo;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @ClassName HippopxPageProcessor
 * @Description TODO
 * @Author JNXJ
 * @Date 2019-03-11 20:19
 * @Version 1.0.0
 **/
@Slf4j
public class HippopxPageProcessor implements PageProcessor {
    private Site site = Site
            .me()
            .setUserAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.121 Safari/537.36")
            .addHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8")
            .addHeader("Accept-Language", "zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3");
   // private static Queue<String> oldUrls=new LinkedBlockingQueue<String>();
    private List<Photo> result=new CopyOnWriteArrayList<Photo>();
    public void process(Page page) {
       // log.info(page.getContent());
        Elements links = page.getDocument().select("img[src]");
        for (Element link:links){
            String title=link.attr("title");
            String url=link.attr("abs:src");
            result.add(new Photo(null,title,url));
            //log.info("title:{}|src:{}",title,url);
        }
    }

    public Site getSite() {
        return this.site;
    }

    public List<Photo> listPhoto(){
        long start=System.currentTimeMillis();
        String[]urls=new String[1700];
        for (int i=1;i<=1700;i++){
            urls[i-1]="https://www.hippopx.com/zh/popular?page="+i;
        }
        HippopxPageProcessor hippopxPageProcessor=new HippopxPageProcessor();
        Spider.create(hippopxPageProcessor)
                .addUrl(urls)
                .thread(20)
                .run();
        log.info("photo number is {}",hippopxPageProcessor.result.size());
        long end=System.currentTimeMillis();
        log.info("Spider took {} seconds",(end-start)/1000);
        return hippopxPageProcessor.result;
    }
}
