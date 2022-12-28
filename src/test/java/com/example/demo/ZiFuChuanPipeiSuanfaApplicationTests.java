package com.example.demo;




import com.example.demo.entity.link.MyNode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;


/**
 * 功能描述 : 字符串匹配算法
 * @author guoyiguang
 * @date 2022/12/28
 * @param
 * @return
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ZiFuChuanPipeiSuanfaApplicationTests {







    /**
     * 功能描述 ：
     * @author guoyiguang
     * @date 2022/12/28
     * @param
     * @return
     */
    @Test
    public void testLocalDateTime() {

        //int sonStringCnt = getSonStringCnt("abcabcdabc", "abc");


    }


    /**
     * 功能描述：  暴力匹配算法
     *
     *
     *      BF （finite Force.暴力匹配）算法也称为朴素匹配算法。
     *
     *      BF算法的思想可以用
     *       一句话来概括：如果 主串长度为m，模式串长度为n 那么在主串
     *       中就会有 m-n+1个长度为 n 的子串，我们只需要“暴力”地对比
     *       这m-n+1个子串与 模式串比对，就可以找出主串与模式串匹配的子串。
     *
     *       example:
     *      主串：  abcdef   长度为m
     *      模式串：abc      长度为n
     *
     *      主串 中 有      m-n+1 个模式串，相当于 从  m-n+1  个元素的 数组中  ，找出 有多少个  模式串
     * @author guoyiguang
     * @date 2022/12/28
     * @param
     * @return
     */
    public int getSonStringCnt(String mainString,String patternString){

        if(StringUtils.isEmpty(mainString) || StringUtils.isEmpty(patternString)){
          return 0;
        }
        // 数组长度
        int size = mainString.length() - patternString.length()+1;
        int i =  0 ;

        for(int a = 0; a < size ;a++){
            //  substring(a,b):  从a开始，截取b-a 个字符串
            //  截取 patternString.length()  个字符串
            String sonString = mainString.substring(a, a+patternString.length());
            if(sonString.equals(patternString)){
                i++;
            }
        }

        return i ;

    }



}
