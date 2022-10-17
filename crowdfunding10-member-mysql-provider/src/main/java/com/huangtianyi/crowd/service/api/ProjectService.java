package com.huangtianyi.crowd.service.api;

import com.huangtianyi.crowd.entity.vo.DetailProjectVO;
import com.huangtianyi.crowd.entity.vo.PortalTypeVO;
import com.huangtianyi.crowd.entity.vo.ProjectVO;

import java.util.List;



public interface ProjectService {

	void saveProject(ProjectVO projectVO, Integer memberId);
	
	List<PortalTypeVO> getPortalTypeVO();
	
	DetailProjectVO getDetailProjectVO(Integer projectId);

}
