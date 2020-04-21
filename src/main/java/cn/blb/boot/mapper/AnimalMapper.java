package cn.blb.boot.mapper;

import cn.blb.boot.beans.Animal;
import org.springframework.stereotype.Component;
import tk.mybatis.mapper.common.Mapper;


@Component
public interface AnimalMapper extends Mapper<Animal> {

}
