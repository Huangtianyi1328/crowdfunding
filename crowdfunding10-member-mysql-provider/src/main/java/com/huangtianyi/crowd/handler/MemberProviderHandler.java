package com.huangtianyi.crowd.handler;

import com.huangtianyi.crowd.constant.CrowdConstant;
import com.huangtianyi.crowd.entity.po.MemberPO;
import com.huangtianyi.crowd.service.api.MemberService;
import com.huangtianyi.crowd.util.ResultEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
public class MemberProviderHandler {
    @Resource
    private MemberService memberService;

    @RequestMapping("/save/member/remote")
    public ResultEntity<String> saveMember(@RequestBody MemberPO memberPO) {
        try {
            // 1.调用本地 Service 完成插入
            memberService.saveMember(memberPO);
            // 2.如果没有抛异常，那么就返回成功的结果
            return ResultEntity.successWithoutData();
        } catch (Exception e) {
            if(e instanceof DuplicateKeyException){
                // 3.如果捕获到异常则返回失败的结果
                return ResultEntity.failed(CrowdConstant.MESSAGE_SYSTEM_ERROR_LOGIN_NOT_UNIQUE);
            }
            e.printStackTrace();
            // 3.如果捕获到异常则返回失败的结果
            return ResultEntity.failed(e.getMessage());
        }
    }
    @RequestMapping("/get/memberpo/by/login/acct/remote")
    public ResultEntity<MemberPO> getMemberPOByLoginAcctRemote(@RequestParam("loginacct") String loginacct) {
        try {
            // 1.调用本地 Service 完成查询
            MemberPO memberPO = memberService.getMemberPOByLoginAcct(loginacct);
            // 2.如果没有抛异常，那么就返回成功的结果
            return ResultEntity.successWithData(memberPO);
        } catch (Exception e) {
            e.printStackTrace();
            // 3.如果捕获到异常则返回失败的结果
            return ResultEntity.failed(e.getMessage());
        }
    }
}