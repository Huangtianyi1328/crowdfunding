package com.huangtianyi.crowd.handler;

import com.huangtianyi.crowd.api.MySQLRemoteService;
import com.huangtianyi.crowd.constant.CrowdConstant;
import com.huangtianyi.crowd.entity.vo.AddressVO;
import com.huangtianyi.crowd.entity.vo.MemberLoginVO;
import com.huangtianyi.crowd.entity.vo.OrderProjectVO;
import com.huangtianyi.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private MySQLRemoteService mySQLRemoteService;


    @RequestMapping("/save/address")
    public String saveAddress(AddressVO addressVO, HttpSession session) {

        // 1.执行地址信息的保存
        ResultEntity<String> resultEntity = mySQLRemoteService.saveAddressRemote(addressVO);

        System.out.println("地址保存处理结果："+resultEntity.getResult());

        // 2.从Session域获取orderProjectVO对象
        OrderProjectVO orderProjectVO = (OrderProjectVO) session.getAttribute("orderProjectVO");

        // 3.从orderProjectVO对象中获取returnCount
        Integer returnCount = orderProjectVO.getReturnCount();

        // 4.重定向到指定地址，重新进入确认订单页面
        return "redirect:http://www.crowd.com/order/confirm/order/"+returnCount;
    }

    @RequestMapping("/confirm/order/{returnCount}")
    public String showConfirmOrderInfo(
            @PathVariable("returnCount") Integer returnCount,
            HttpSession session) {

        // 1.把接收到的回报数量合并到Session域
        OrderProjectVO orderProjectVO = (OrderProjectVO) session.getAttribute("orderProjectVO");

        orderProjectVO.setReturnCount(returnCount);
        System.out.println(orderProjectVO);
        session.setAttribute("orderProjectVO", orderProjectVO);

        // 2.获取当前已登录用户的id
        MemberLoginVO memberLoginVO = (MemberLoginVO) session.getAttribute(CrowdConstant.ATTR_NAME_LOGIN_MEMBER);

        Integer memberId = memberLoginVO.getId();
        System.out.println(memberLoginVO);
        // 3.查询目前的收货地址数据
        ResultEntity<List<AddressVO>> resultEntity = mySQLRemoteService.getAddressVORemote(memberId);

        if(ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
            List<AddressVO> list = resultEntity.getData();
            session.setAttribute("addressVOList", list);
        }

        return "confirm_order";
    }

    @RequestMapping("/confirm/return/info/{projectId}/{returnId}")
    public String showReturnConfirmInfo(
            @PathVariable("projectId") Integer projectId,
            @PathVariable("returnId") Integer returnId,
            HttpSession session) {

        ResultEntity<OrderProjectVO> resultEntity =
                mySQLRemoteService.getOrderProjectVORemote(projectId, returnId);

        if(ResultEntity.SUCCESS.equals(resultEntity.getResult())) {
            OrderProjectVO orderProjectVO = resultEntity.getData();

            // 为了能够在后续操作中保持orderProjectVO数据，存入Session域
            session.setAttribute("orderProjectVO", orderProjectVO);
        }

        return "confirm_return";
    }

}
