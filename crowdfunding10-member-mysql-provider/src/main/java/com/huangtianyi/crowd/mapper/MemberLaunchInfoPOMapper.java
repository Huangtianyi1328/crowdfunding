package com.huangtianyi.crowd.mapper;

import com.huangtianyi.crowd.entity.po.MemberLaunchInfoPO;
import com.huangtianyi.crowd.entity.po.MemberLaunchInfoPOExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberLaunchInfoPOMapper {
    long countByExample(MemberLaunchInfoPOExample example);

    int deleteByExample(MemberLaunchInfoPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(MemberLaunchInfoPO record);

    int insertSelective(MemberLaunchInfoPO record);

    List<MemberLaunchInfoPO> selectByExample(MemberLaunchInfoPOExample example);

    MemberLaunchInfoPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") MemberLaunchInfoPO record, @Param("example") MemberLaunchInfoPOExample example);

    int updateByExample(@Param("record") MemberLaunchInfoPO record, @Param("example") MemberLaunchInfoPOExample example);

    int updateByPrimaryKeySelective(MemberLaunchInfoPO record);

    int updateByPrimaryKey(MemberLaunchInfoPO record);
}