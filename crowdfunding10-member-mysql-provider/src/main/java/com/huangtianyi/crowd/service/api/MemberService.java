package com.huangtianyi.crowd.service.api;

import com.huangtianyi.crowd.entity.po.MemberPO;

public interface MemberService {
    MemberPO getMemberPOByLoginAcct(String loginacct);
    void saveMember(MemberPO memberPO);
}
