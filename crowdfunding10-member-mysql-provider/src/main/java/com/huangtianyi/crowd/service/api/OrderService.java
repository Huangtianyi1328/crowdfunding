package com.huangtianyi.crowd.service.api;

import com.huangtianyi.crowd.entity.vo.AddressVO;
import com.huangtianyi.crowd.entity.vo.OrderProjectVO;
import com.huangtianyi.crowd.entity.vo.OrderVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OrderService {

	OrderProjectVO getOrderProjectVO(Integer projectId, Integer returnId);

	List<AddressVO> getAddressVOList(Integer memberId);

	void saveAddress(AddressVO addressVO);

	void saveOrder(OrderVO orderVO);

}
