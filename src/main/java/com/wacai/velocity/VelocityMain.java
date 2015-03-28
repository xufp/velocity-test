package com.wacai.velocity;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;
import org.apache.velocity.context.Context;

import java.io.StringWriter;
import java.util.Date;
import java.util.Properties;

/**
 * velocity框架示例
 * 简介：velocity，apache下开源项目，基于JAVA语言的模板引擎，允许使用简单的模板语言来引用JAVA代码定义的对象
 *       velocity将java代码与web页面进行分离，使我们除了JSP与PHP之外多了一种选择
 * Created by duanshi on 2015/3/28.
 */
public class VelocityMain {

    /**
     * 最简单的使用方式
     * 1.初始化velocity引擎
     * 2.选择VM模板文件，与参数合并一个完整的页面
     * 3.输出SW
     * @param args
     */
    public static void main(String[] args) {
        try {
            //加载velocity.properties配置文件，如果不加载，默认取velocity.jar下的velocity.properties（org。apache。velocity。runtime。defaults。velocity.properties）文件初始化引擎
            Properties properties = new Properties();
            properties.load(Velocity.class.getResourceAsStream("/velocity.properties"));
            //初始化引擎，有三种初始化方法1.init();2.init(string propertiesname);3.init(Properties properties)
            Velocity.init(properties);
            //merge template
            StringWriter sw = new StringWriter();
            //模板参数
            VelocityContext velocityContext = new VelocityContext();
            velocityContext.put("userName", "duanshi");
            velocityContext.put("days", DateFormatUtils.format(new Date(), "yyyy-MM-dd"));
            //模板合并
            Velocity.mergeTemplate("testTemplate.vm", "UTF-8", velocityContext, sw);
            //输出合并后的模板
            System.out.print(sw.toString());
        } catch(Exception e) {
            e.printStackTrace();
        }


    }

}
