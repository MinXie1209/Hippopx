### HIPPOPX图片搜索商城

#### 模块划分

- Hippopx:父模块，打包方式pom
    - dao : 使用mysql,mybatis-plus搭建的数据交互模块
    - entity ： pojo类
    - util ： 工具类
    - web ：程序入口，还可划分为多个模块
  
#### 功能展望

- 图片搜索器：使用ElastiSearch技术
- 数据来源：使用[CrawlingSpider]("https://github.com/xyj1209/CrawlingSpider")爬虫作为底层爬取数据的工具
