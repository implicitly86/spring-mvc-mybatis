package com.implicitly.persistence;

import com.implicitly.models.Category;
import org.apache.ibatis.annotations.Select;

/**
 * @author EMurzakaev@it.ru.
 */
public interface CategoryMapper {

    @Select("select * from category where id = #{id}")
    Category getCategory(long id);

}
