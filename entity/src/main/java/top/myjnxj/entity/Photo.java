package top.myjnxj.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @ClassName Photo
 * @Description TODO
 * @Author JNXJ
 * @Date 2019-03-25 9:57
 * @Version 1.0.0
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Photo {
    private Long id;
    private String title;
    private String url;
}
