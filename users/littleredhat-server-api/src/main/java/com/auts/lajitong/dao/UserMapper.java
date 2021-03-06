package com.auts.lajitong.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.auts.lajitong.model.dao.UserModel;


/**
 * 用户属性入口.
 * @author huangrongwei
 *
 */
public interface UserMapper {

    @Update("update tbl_user set nick_name = #{nickName}, sex=#{sex} where id=#{id}")
    int updateUser(@Param("id") String id, @Param("nickName") String nickName,@Param("sex") int sex);
    
    @Update("update tbl_user set nick_name = #{model.nickName}, sex=#{model.sex},status=#{model.status},current_profit=#{model.currentProfit},deliver_count=#{model.deliverCount},total_profit=#{model.totalProfit},wxs_open_id=#{model.wxsOpenId} where id=#{model.id}")
    int updateUserModel(@Param("model") UserModel model);

    @Update("update tbl_user set nick_name = #{nickName} where id=#{id}")
    int updateUserNickName(@Param("id") String id, @Param("nickName") String nickName);

    @Update("update tbl_user set sex=#{sex} where id=#{id}")
    int updateUserSex(@Param("id") String id, @Param("sex") int sex);
    
    @Update("update tbl_user set total_profit = #{totalProfit}, current_profit = #{currentProfit} , deliver_count = deliver_count + 1 where id=#{id}")
    int updateTotalProfit(@Param("id") String id, @Param("totalProfit") String totalProfit, @Param("currentProfit") String currentProfit);

    @Insert("insert into tbl_user (id, account_id, nick_name, sex, status, total_profit, current_profit, wxs_open_id, create_time) "
            + "values (#{model.id}, #{model.accountId},#{model.nickName},#{model.sex},#{model.status},#{model.totalProfit},#{model.currentProfit},#{model.wxsOpenId},#{model.createTime})")
    int addUser(@Param("model") UserModel model);

    @Select("select * from tbl_user where account_id=#{accountId} and status=0 limit 1")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "accountId", column = "account_id"),
        @Result(property = "nickName", column = "nick_name"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "status", column = "status"),
        @Result(property = "totalProfit", column = "total_profit"),
        @Result(property = "currentProfit", column = "current_profit"),
        @Result(property = "deliverCount", column = "deliver_count"),
        @Result(property = "wxsOpenId", column = "wxs_open_id"),
        @Result(property = "createTime", column = "create_time")
    })
    UserModel queryUserByAccountId(@Param("accountId") String accountId);

    @Select("select * from tbl_user where id=#{userId} and status=0 limit 1")
    @Results({
        @Result(property = "id", column = "id"),
        @Result(property = "accountId", column = "account_id"),
        @Result(property = "nickName", column = "nick_name"),
        @Result(property = "sex", column = "sex"),
        @Result(property = "status", column = "status"),
        @Result(property = "totalProfit", column = "total_profit"),
        @Result(property = "currentProfit", column = "current_profit"),
        @Result(property = "deliverCount", column = "deliver_count"),
        @Result(property = "wxsOpenId", column = "wxs_open_id"),
        @Result(property = "createTime", column = "create_time")
    })
    UserModel queryUserByUserid(@Param("userId") String userId);
}
