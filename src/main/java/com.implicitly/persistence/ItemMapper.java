package com.implicitly.persistence;

import com.implicitly.models.Category;
import com.implicitly.models.Item;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author EMurzakaev@it.ru.
 */
public interface ItemMapper {

    @Insert("insert into items values (#{id}, #{name}, #{category.id})")
    @Results(value = {
            @Result(
                    property = "category",
                    column = "ref_category",
                    one = @One(select = "com.implicitly.persistence.CategoryMapper.getCategory"),
                    javaType = Category.class
            )
    })
    int addItem(final Item item);

    @Select("select * from items where id = #{id}")
    @Results(value = {
            @Result(
                    property = "category",
                    column = "ref_category",
                    one = @One(select = "com.implicitly.persistence.CategoryMapper.getCategory"),
                    javaType = Category.class
            )
    })
    Item getItem(final long id);

    @Update("update items set name =#{name}, ref_category = #{category.id} where id =#{id}")
    @Results(value = {
            @Result(
                    property = "category",
                    column = "ref_category",
                    one = @One(select = "com.implicitly.persistence.CategoryMapper.getCategory"),
                    javaType = Category.class
            )
    })
    int updateItem(final Item item);

    @Delete("delete from items where id =#{id}")
    int deleteItem(final long id);

    @Select("select * from items")
    @Results(value = {
            @Result(
                    property = "category",
                    column = "ref_category",
                    one = @One(select = "com.implicitly.persistence.CategoryMapper.getCategory"),
                    javaType = Category.class
            )
    })
    List<Item> getItems();

}
