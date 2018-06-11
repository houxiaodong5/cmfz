import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2018/6/7.
 */
public class Test2 {
    public static void main(String[] args) {
        Jedis jedis=new Jedis("127.0.0.1",6379);
        jedis.set("user", "wangwu");
        Boolean exists = jedis.exists("user");
        System.out.println(exists);
        jedis.expire("user", 1000);

    }
}
