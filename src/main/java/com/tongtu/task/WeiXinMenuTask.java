package com.tongtu.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.usc.wechat.mp.sdk.util.platform.MenuUtil;
import org.usc.wechat.mp.sdk.vo.menu.Menu;
import org.usc.wechat.mp.sdk.vo.token.License;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * 项目名称：
 * 功能描述：
 * 创建人:ahtt_nsj
 * 创建时间:2014/9/15 0015 15:06
 * 修改人：
 * 修改时间:
 *
 * @版本：V
 */
@Named("weiXinMenuTask")
public class WeiXinMenuTask {
    @Inject
    private Menu menu;
    @Inject
    private License license;
    //@Scheduled(fixedDelay=1000)  //第一种方式
    //fixedDelay延时多少毫秒，多少毫秒执行一次
    @Scheduled(cron="0 0 * * * *")
     /*
        1 Seconds (0-59)
        2 Minutes (0-59)
        3 Hours (0-23)
        4 Day of month (1-31)
        5 Month (1-12 or JAN-DEC)
        6 Day of week (1-7 or SUN-SAT)
        7 Year (1970-2099)
        取值：可以是单个值，如6；
            也可以是个范围，如9-12；
            也可以是个列表，如9,11,13
            也可以是任意取值，使用*
    */
    //0 * * * * * 代表每分钟执行一次
    /*
        2011-09-07 09:23:00
        2011-09-07 09:24:00
        2011-09-07 09:25:00
        2011-09-07 09:26:00
     */
    public void reflashMenu(){
        MenuUtil.createMenu(license, menu);
    }
}
