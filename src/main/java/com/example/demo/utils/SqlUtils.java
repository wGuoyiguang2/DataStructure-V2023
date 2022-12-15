package com.example.demo.utils;

/**
 * @author guoyiguang
 * @description sql工具类$
 * @date 2022/9/13$
 */
public class SqlUtils {

    /**
     * 功能描述   每页10条数据，需要循环几次获取任务
     * @author guoyiguang
     * @date 2022/9/13
     * @param
     * @return
     */
    public static int getForCount1(int sum,int pageSize){
        if(sum==0){
            return 0 ;
        }
        int count = 1 ;
        if(sum > pageSize){
            count =  sum/pageSize;
            if(sum%pageSize>0){
                count = count+1 ;
            }

        }
        return count;
    }




}
