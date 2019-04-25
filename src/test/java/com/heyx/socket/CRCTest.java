package com.heyx.socket;

import com.heyx.socket.util.CRCUtil;
import org.junit.Test;

/**
 * @description:
 * @author: heyx
 * @create: 2019-04-25 14:05
 * @email; 1064042411@qq.com
 */
public class CRCTest {


    @Test
    public void parseSource(){
        String source = "##0314QN=20190314074359000;" +
                "ST=A1;" +
                "CN=2051;" +
                "PW=123456;" +
                "MN=003703030000001122053320;" +
                "Flag=5;" +
                "CP=&&DataTime=20190314074359000;" +
                "a34002-Rtd=327.0,a34002-Flag=N;" +
                "a34004-Rtd=266.5,a34004-Flag=N;" +
                "a01001-Rtd=-2.0,a01001-Flag=N;" +
                "a01002-Rtd=58.9,a01002-Flag=N;" +
                "a01008-Rtd=90,a01008-Flag=N;" +
                "a01007-Rtd=0.0,a01007-Flag=N;" +
                "LA-Rtd=30.2,LA-Flag=N&&";
        String source1 = "ST=43;CN=2011;PW=123456;MN=ZKC4717063080818900;CP=&&DataTime=20170726134851000;PM10-Rtd=33,PM10-Flag=N;ZY-Rtd=61.1,ZY-Flag=N&&";
        int cRcNum = CRCUtil.getCRC( source1);
        System.out.println(CRCUtil.numToHex8(cRcNum));

    }

    @Test
    public void parseInteger(){
        //16进制转int,使用Integer.parseUnsignedInt(s, 16)
        System.out.println(Integer.parseUnsignedInt("64", 16));
        System.out.println(Integer.parseUnsignedInt("ffffff9c", 16));
    }
}
