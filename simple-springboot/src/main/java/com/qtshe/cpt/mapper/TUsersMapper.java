package com.qtshe.cpt.mapper;

import com.qtshe.cpt.model.TUsers;
import java.util.List;

public interface TUsersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbggenerated Tue Nov 27 11:26:30 GMT+08:00 2018
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbggenerated Tue Nov 27 11:26:30 GMT+08:00 2018
     */
    int insert(TUsers record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbggenerated Tue Nov 27 11:26:30 GMT+08:00 2018
     */
    TUsers selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbggenerated Tue Nov 27 11:26:30 GMT+08:00 2018
     */
    List<TUsers> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_users
     *
     * @mbggenerated Tue Nov 27 11:26:30 GMT+08:00 2018
     */
    int updateByPrimaryKey(TUsers record);
}