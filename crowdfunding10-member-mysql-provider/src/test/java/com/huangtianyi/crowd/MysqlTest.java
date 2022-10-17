package com.huangtianyi.crowd;

import com.huangtianyi.crowd.service.api.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlTest {
    @Autowired
    private MemberService memberService;
    @Test
    public void testLogin(){
        System.out.println(memberService.getMemberPOByLoginAcct("hty"));
    }
}
