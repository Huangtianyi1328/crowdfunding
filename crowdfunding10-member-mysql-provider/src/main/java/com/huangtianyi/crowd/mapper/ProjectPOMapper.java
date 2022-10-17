package com.huangtianyi.crowd.mapper;

import com.huangtianyi.crowd.entity.po.ProjectPO;
import com.huangtianyi.crowd.entity.po.ProjectPOExample;
import com.huangtianyi.crowd.entity.vo.DetailProjectVO;
import com.huangtianyi.crowd.entity.vo.PortalTypeVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ProjectPOMapper {
    long countByExample(ProjectPOExample example);

    int deleteByExample(ProjectPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProjectPO record);

    int insertSelective(ProjectPO record);

    List<ProjectPO> selectByExample(ProjectPOExample example);

    ProjectPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

    int updateByExample(@Param("record") ProjectPO record, @Param("example") ProjectPOExample example);

    int updateByPrimaryKeySelective(ProjectPO record);

    int updateByPrimaryKey(ProjectPO record);

    void insertTypeRelationship(@Param("typeIdList") List<Integer> typeIdList,@Param("projectId")  Integer projectId);

    void insertTagRelationship(@Param("tagIdList") List<Integer> tagIdList,@Param("projectId")  Integer projectId);

    DetailProjectVO selectDetailProjectVO(Integer projectId);

    List<PortalTypeVO> selectPortalTypeVOList();
}