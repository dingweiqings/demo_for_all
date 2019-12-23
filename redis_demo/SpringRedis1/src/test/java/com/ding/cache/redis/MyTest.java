package com.ding.cache.redis;
import static org.junit.Assert.assertNotNull;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.junit.Test;

import com.ding.cache.redis.entity.User;

import redis.clients.jedis.Jedis;
public class MyTest {
    @Test
	public void TestJedisConnection(){
        //连接本地的 Redis 服务
        Jedis jedis = new Jedis("192.168.157.132");
        System.out.println("连接成功");
        //查看服务是否运行
        System.out.println("服务正在运行: "+jedis.ping());
        User p=new User();  //peson类记得实现序列化接口 Serializable
        p.setName("姚波");
        p.setId(1);
        jedis.set("person".getBytes(), serialize(p));
        byte[] byt=jedis.get("person".getBytes());
        System.out.println(jedis.get("person".getBytes()));
        Object obj=unserizlize(byt);
        if(obj instanceof User){
        	User u=(User) obj;
            System.out.println(u.getId()+u.getName());
        }
    }
    //存对象



//序列化 
public static byte [] serialize(Object obj){
    ObjectOutputStream obi=null;
    ByteArrayOutputStream bai=null;
    try {
        bai=new ByteArrayOutputStream();
        obi=new ObjectOutputStream(bai);
        obi.writeObject(obj);
        byte[] byt=bai.toByteArray();
        return byt;
    } catch (IOException e) {
        e.printStackTrace();
    }
    return null;
}

//反序列化
public static Object unserizlize(byte[] byt){
    ObjectInputStream oii=null;
    ByteArrayInputStream bis=null;
    bis=new ByteArrayInputStream(byt);
    try {
        oii=new ObjectInputStream(bis);
        Object obj=oii.readObject();
        return obj;
    } catch (Exception e) {
        
        e.printStackTrace();
    }
   
    return null;
}
@Test
public void objectIoTest() throws IOException, ClassNotFoundException{
	User user=new User();
	user.setId(2);
	user.setName("Kurt");
	//通过Object Stream作为中介
	//一般out流在创建时候都要指定一个目的地，因为流要流向这个地方，除非这个流可以作为流的终点，
	//比如ByteArrayOutputStream
	ByteArrayOutputStream byteOut=new ByteArrayOutputStream();
	ObjectOutputStream objOut=new ObjectOutputStream(byteOut);
	objOut.writeObject(user);
	byte[] objArray=byteOut.toByteArray();
	int len=objArray.length;
	for(int i=0;i<len;i++){
		System.out.println(objArray[i]);
	}
	ByteArrayInputStream byteInput=new ByteArrayInputStream(objArray);
    ObjectInputStream objInput=new ObjectInputStream(byteInput);
	User result=(User)objInput.readObject();
	assertNotNull(result.getId());
	System.out.println(result.getId()+result.getName());
	
}










}
