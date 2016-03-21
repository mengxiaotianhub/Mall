package com.mengxiaotian.learn.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mengxiaotian.learn.mall.meta.Goods;

public interface GoodsMapper {
	@Insert("INSERT INTO Goods (name,description,point,published,isDelete) Value(#{name},#{description},#{point},#{published},#{isDelete})")
	public void addGoods(Goods goods);

	@Delete("DELETE Goods WHERE id=#{id}")
	public void deleteGoods(int id);

	@Update("UPDATE Goods SET name=#{name},description=#{description},point=#{point},published=#{published},isDelete=#{isDelete} WHERE id=#{id}")
	public void updateGoods(Goods goods);

	@Select("SELECT * FROM Goods WHERE published=#{published}  AND isDelete=false")
	public List<Goods> getAllGoods(boolean published);

	@Select("SELECT * FROM Goods WHERE #{colunm}=#{value}")
	public List<Goods> getGoods(@Param("colunm") String colunm, @Param("value") String value);
	
	@Select("SELECT * FROM Goods WHERE id=#{id}")
	public Goods getOneGoods(int id);
	
	@Select("SELECT * FROM Goods WHERE isDelete=true")
	public List<Goods> getdelete();
}
