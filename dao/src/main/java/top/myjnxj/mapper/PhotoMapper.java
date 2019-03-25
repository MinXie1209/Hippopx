package top.myjnxj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import top.myjnxj.entity.Photo;

import java.util.List;

/**
 * @ClassName PhotoMapper
 * @Description TODO
 * @Author JNXJ
 * @Date 2019-03-25 12:58
 * @Version 1.0.0
 **/
public interface PhotoMapper extends BaseMapper<Photo> {
    @Insert("<script> insert into photo (title,url) values " +
            "<foreach collection='list' item='item' separator=','>" +
            "(#{item.title},#{item.url})" +
            "</foreach></script>")
    int insertList(@Param("list") List<Photo> photos);
}
