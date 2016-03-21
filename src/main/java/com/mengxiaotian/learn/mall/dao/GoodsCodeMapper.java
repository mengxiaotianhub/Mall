package com.mengxiaotian.learn.mall.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mengxiaotian.learn.mall.meta.GoodsCode;

public interface GoodsCodeMapper {
	@Insert("INSERT INTO GoodsCode (userName,goodsId,code,exchangeTime,exchanged) VALUE(#{userName},#{goodsId},#{code},#{exchangeTime},#{exchanged})")
	public void addGoodsCode(GoodsCode goodsCode);

	@Delete("DELETE GoodsCode WHERE id=#{id}")
	public void deleteGoodsCode(int id);

	@Update("UPDATE GoodsCode SET userName=#{userName},goodsId=#{goodsId},code=#{code},exchangeTime=#{exchangeTime},exchanged=#{exchanged} WHERE id=#{id}")
	public void updateGoodsCode(GoodsCode goodsCode);

	@Select("SELECT * FROM GoodsCode ORDER BY exchangeTime DESC,goodsId,userName")
	public List<GoodsCode> getAllGoodsCode();

	@Select("SELECT * FROM GoodsCode WHERE #{colunm}=#{value}")
	public List<GoodsCode> getCodes(@Param("colunm") String colunm, @Param("value") String value);
	
	@Select("SELECT * FROM GoodsCode WHERE exchanged=false AND goodsId=#{goodsId} LIMIT 1")
	public GoodsCode getOneNotExchenged(int goodsId);

}
