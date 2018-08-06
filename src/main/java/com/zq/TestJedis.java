package com.zq;

import com.com.session.MySessionContext;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpSession;

public class TestJedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("localhost");
       /* jedis.set("foo", "bar");
        String value = jedis.get("foo");
        System.out.println(value);
        jedis.del("foo");
        System.out.println(jedis.get("foo"));
        System.out.println(jedis.keys("*"));*/
       // System.out.println(jedis.get("7A5F6B6B9CA5C759451E5B8E60A697D9"));
        //MySessionContext myc= MySessionContext.getInstance();
      //  HttpSession sess = myc.getSession("7A5F6B6B9CA5C759451E5B8E60A697D9");
       // System.out.println(jedis.ttl("7A5F6B6B9CA5C759451E5B8E60A697D9"));
        System.out.println(jedis.keys("*"));
        //jedis.setex("26BE25A45D1EA78A8AEE069F0AFFCFF8", 10, "min");
        //System.out.println(jedis.ttl("6F8BC54D74903E521A6C402D2F21DF00"));
       // jedis.setex("B08642FAF1F146E4E02CA3CE148EADD7", 1000, "min");
       // System.out.println(jedis.ttl("32094AC369743AB17E1DA405F22ECEE3"));
        System.out.println(jedis.get("253AFCF2CB0FAA8C02747A6ADD94010D"));

    }
}
