package com.web.Request;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.web.Return.Environment;
import com.web.controller.GetEnvironment;
import com.web.core.Http;
import com.web.core.Request;
import org.testng.Assert;

import java.util.*;

/**
 * Created by song on 17/4/25.
 * 课件请求
 */
public class Courseware {

    /**
     * 图片
     */
    List<String> images = new ArrayList<>();
    //iamge count
    int imageCount = 0;

    /**
     * 环境信息
     */
    Environment en = new GetEnvironment().getInfo();

    public Courseware() {
        switch (en.getEnvironment()) {
            case "测试环境":
                images.add("http://qdtestfile.faxuan.net/study/4ddb21aa6e2a47f9917d20fc78402abc.jpg");
                images.add("http://qdtestfile.faxuan.net/study/f26cdaa469c74c86bd70320daac290e3.jpg");
                images.add("http://qdtestfile.faxuan.net/study/a4c68b364aca4793ada25827360d1a39.jpg");
                images.add("http://qdtestfile.faxuan.net/study/50cc77f7a3914e53bc2c000a7035244d.jpg");
                images.add("http://qdtestfile.faxuan.net/study/95a04573cf424ce9a4ca37800d561052.jpg");
                images.add("http://qdtestfile.faxuan.net/study/7ec0a7b8209544928981bb0c62214264.jpg");
                images.add("http://qdtestfile.faxuan.net/study/06087444e2194a628834db10ea78ec1e.jpg");
                images.add("http://qdtestfile.faxuan.net/study/7512e243457648e09900137279cea837.jpg");
                images.add("http://qdtestfile.faxuan.net/study/d26fb058ffe145f585034fa20e0043b1.jpg");
                images.add("http://qdtestfile.faxuan.net/study/7c33aaafd94e42f8a854234ccc676a34.jpg");
                images.add("http://qdtestfile.faxuan.net/study/4159f04ca13942cab69aa4c2ee3ea035.jpg");
                images.add("http://qdtestfile.faxuan.net/study/3e7d229cd86948308e03afdcc1915c3c.jpg");
                images.add("http://qdtestfile.faxuan.net/study/65129e9dec4a426287598329873c42ec.jpg");
                images.add("http://qdtestfile.faxuan.net/study/e1b3e063098149fa9513f54ce67c931a.jpg");
                images.add("http://qdtestfile.faxuan.net/study/2ceabbcd50e5437ca2e7bffb1848d8f4.jpg");
                images.add("http://qdtestfile.faxuan.net/study/7e5dbb08341f4ea68ad71655edb0d34c.jpg");
                images.add("http://qdtestfile.faxuan.net/study/96629eb76a1a4c78bd66abff2efeca28.jpg");
                images.add("http://qdtestfile.faxuan.net/study/9c530f8c672e479ab07c66cbc9ad56ef.jpg");
                images.add("http://qdtestfile.faxuan.net/study/57cb0e760bda4d54a2c7ec7caa27c5b8.jpg");
                images.add("http://qdtestfile.faxuan.net/study/93d8207dd2394b1d9d60514c7029f131.jpg");
                images.add("http://qdtestfile.faxuan.net/study/514e6c26b6114580884445db4a6537a5.jpg");
                images.add("http://qdtestfile.faxuan.net/study/aaa578351b804a3bb6aa3865c9cc8062.jpg");
                images.add("http://qdtestfile.faxuan.net/study/3138f815956442f68a7ca6d495de92d6.jpg");
                images.add("http://qdtestfile.faxuan.net/study/22f74b6171ff4adf9df2b751f92c059b.jpg");
                images.add("http://qdtestfile.faxuan.net/study/f926245a03d04af6838a464916e546dd.jpg");
                images.add("http://qdtestfile.faxuan.net/study/31d9d01af5844f3aa3dfbc93c57fb831.jpg");
                images.add("http://qdtestfile.faxuan.net/study/49af84d2256549d7b65f80335b6a2e3b.jpg");
                images.add("http://qdtestfile.faxuan.net/study/d424f1438d784976b2cb3d8b55d7921c.JPG");
                images.add("http://qdtestfile.faxuan.net/study/828cfbe5dc974e8394dd30b204516801.JPG");
                imageCount = 29;
                break;
            case "预上线环境":
                images.add("http://stagfile.faxuan.net/study/0284efea8eaa4c53849892f1bd09473d.jpg");
                images.add("http://stagfile.faxuan.net/study/9b625388bf454efa9ad0f24848c598fb.JPG");
                images.add("http://stagfile.faxuan.net/study/9647f879e9a147c68f118f59a0b42423.JPG");
                images.add("http://stagfile.faxuan.net/study/5cfdd3af7aa9457995bceafe855936b3.jpg");
                images.add("http://stagfile.faxuan.net/study/7219a35ce7ab41e8ac13aea52e5d55f2.JPG");
                images.add("http://stagfile.faxuan.net/study/af068e7ccff94918a1badd73e8ebb176.jpg");
                images.add("http://stagfile.faxuan.net/study/04d3b994f46748ab94f12a9d6a714a08.jpg");
                images.add("http://stagfile.faxuan.net/study/25a55975c91c4e298e45e4c4d0defb1e.jpg");
                images.add("http://stagfile.faxuan.net/study/06dfd185d5bb4f8b93972f167721f4f6.jpg");
                images.add("http://stagfile.faxuan.net/study/9b063dbaf25d4436be8c5d8fb0f64bf2.jpg");
                images.add("http://stagfile.faxuan.net/study/39dfdf4006ed408084067d05e91fadc0.jpg");
                images.add("http://stagfile.faxuan.net/study/92960f4ada6845ec975d60cfb272adae.jpg");
                images.add("http://stagfile.faxuan.net/study/d069568bece34492806bdf39b7bc8910.jpg");
                images.add("http://stagfile.faxuan.net/study/5e4d0877ad4b48cab6f8943c0b896347.JPG");
                images.add("http://stagfile.faxuan.net/study/87f757f45c6f47cab6c16f63b655030d.jpg");
                images.add("http://stagfile.faxuan.net/study/b2de5d8727d849b288f088ff0502c2a7.jpg");
                images.add("http://stagfile.faxuan.net/study/3751799d39a64311974e3307dd98b60d.jpg");
                images.add("http://stagfile.faxuan.net/study/cdbc8864883b4051b39e4f5de08b7c51.jpg");
                images.add("http://stagfile.faxuan.net/study/395536c74fe043af961c80b6eb958f61.jpg");
                images.add("http://stagfile.faxuan.net/study/c1ead997a1a243679e3996088a46220d.jpg");
                images.add("http://stagfile.faxuan.net/study/0035f4468ec74247b58295a54f1b897a.jpg");
                images.add("http://stagfile.faxuan.net/study/66b7213d5f8e41dd9bb8242e98757020.jpg");
                images.add("http://stagfile.faxuan.net/study/36afdeb50be942de833c3e9a5a39bfc0.jpg");
                images.add("http://stagfile.faxuan.net/study/38916a339d8b45f2afa7ff89ba4c14c8.jpg");
                images.add("http://stagfile.faxuan.net/study/54e3437b4ad84165b3bb6089391e3291.jpg");
                images.add("http://stagfile.faxuan.net/study/63beb870fd9449b98a65135a878cd3fb.jpg");
                images.add("http://stagfile.faxuan.net/study/7339a8f6167f4d368b32135dfefabae1.jpg");
                images.add("http://stagfile.faxuan.net/study/267fd310be344630aab353a7b6a968f8.jpg");
                imageCount = 28;
                break;
            case "线上环境":
                images.add("http://file.faxuan.net/study/60462bef04de4551871a1497788e0c48.jpg");
                images.add("http://file.faxuan.net/study/86982bf0b9e942d5b09296576bc370e3.jpg");
                images.add("http://file.faxuan.net/study/f2ded9ee875c4fc69c0c3cc2cf8ea08d.jpg");
                images.add("http://file.faxuan.net/study/a3efedb2ddc2401ab4d6a0dc6c3b920f.JPG");
                images.add("http://file.faxuan.net/study/3e47c309eb6344e19ba35434416f912b.JPG");
                images.add("http://file.faxuan.net/study/0797f43716c344f4916a537d4ad48fdb.JPG");
                images.add("http://file.faxuan.net/study/b4dab26fdc4a48658c262349f502d891.jpg");
                images.add("http://file.faxuan.net/study/a4e17c5c0d734246b9d93fc60913f2f9.JPG");
                images.add("http://file.faxuan.net/study/9b8a063c95364df7b56f6fc63870854d.jpg");
                images.add("http://file.faxuan.net/study/204852f573ba4c079846f391ac366502.jpg");
                images.add("http://file.faxuan.net/study/053617ca8f4f45568475a75b08599350.jpg");
                images.add("http://file.faxuan.net/study/60e11a78adc842bbb478a342c0c52f4f.jpg");
                images.add("http://file.faxuan.net/study/a15b9dfc0e8a4a3fae883d0a328b28d7.jpg");
                images.add("http://file.faxuan.net/study/c40462c5e570493cb79a9c5300a1ba66.jpg");
                images.add("http://file.faxuan.net/study/5a1642686f08424c9fc769447a154358.jpg");
                images.add("http://file.faxuan.net/study/509e32fca1e844c2aca58fd852ddbebf.jpg");
                images.add("http://file.faxuan.net/study/73d30bb004d14de58636d0524844dabe.jpg");
                images.add("http://file.faxuan.net/study/38d47a4fe67b47b9a2f1ceae193ca6c1.jpg");
                images.add("http://file.faxuan.net/study/d0694628bb844aecb9d5a6629022f134.jpg");
                images.add("http://file.faxuan.net/study/ab3a096e2f2c417abf72893bdff3633e.jpg");
                images.add("http://file.faxuan.net/study/500921fca63f41d69dc75419605d554a.jpg");
                images.add("http://file.faxuan.net/study/05318687119d4536a8f95ddb8ee87328.jpg");
                images.add("http://file.faxuan.net/study/ff1a49e098fe43b096f652d3a1a69a7a.jpg");
                images.add("http://file.faxuan.net/study/c296362fb56347438c0bbb376b3e7922.jpg");
                images.add("http://file.faxuan.net/study/867dcd97c99641738cf9f374c755461f.jpg");
                images.add("http://file.faxuan.net/study/73e91c6eb7e146529fb72a95aab70597.jpg");
                images.add("http://file.faxuan.net/study/003c8e5452cc4dc79082fba910cc88b2.jpg");
                images.add("http://file.faxuan.net/study/730506b7b9154ea7bde59847d8184c91.jpg");
                imageCount=28;
        }
    }

    /**
     * 视频
     */
    String[] videos = {"http://file.faxuan.net/video/20160310/pfdm_01_512.mp4","http://file.faxuan.net/video/20160310/pfdm_02_512.mp4","http://file.faxuan.net/video/20160310/pfdm_03_512.mp4"
            ,"http://file.faxuan.net/video/20160310/pfdm_04_512.mp4","http://file.faxuan.net/video/20160310/pfdm_05_512.mp4","http://file.faxuan.net/video/20160310/pfdm_06_512.mp4"
            ,"http://file.faxuan.net/video/20160310/pfdm_07_512.mp4","http://file.faxuan.net/video/20160310/pfdm_08_512.mp4","http://file.faxuan.net/video/20160310/pfdm_9_512.mp4"
            ,"http://file.faxuan.net/video/20160310/pfdm_10_512.mp4","http://file.faxuan.net/video/20160310/pfdm_11_512.mp4","http://file.faxuan.net/video/20160310/pfdm_12_512.mp4"
            ,"http://file.faxuan.net/video/20160310/pfdm_13_512.mp4","http://file.faxuan.net/video/20160310/pfdm_14_512.mp4","http://file.faxuan.net/video/20160310/pfdm_15_512.mp4"};

    Map<Object,Object> param = new HashMap<Object, Object>();

    public void addParamForCourseId(String courseId) {
        param.put("vo.bean.courseId",courseId);
    }


    public void  addParamForUserInfo(String domainCode,String userName) {
        param.put("vo.organNo",domainCode);
        param.put("vo.userId",userName);
    }

    private void addParam() {
        //课件名称时间戳
        param.put("vo.bean.courseWareName", "自动添加课件");

        //课件类型
        param.put("vo.bean.courseWareType",1);

        //课件模板
        param.put("vo.bean.courseWareTemplate",2);

        //排序号
        param.put("vo.bean.sort",1);

        //课件图片
        param.put("vo.bean.resourseUrl","http://qdtestfile.faxuan.net/study/55f98538d3234d239b2e5e3fc91c493a.JPG");

        //课件描述
        param.put("vo.bean.couresWareDiscription","<p>我是课件描述！！</p>");
    }





    /**
     * 请求添加课程接口
     * @return 请求返回状态
     */
    public Request doRequest() {
        addParam();
        return new Http()
                .setUrl("/sss/service/coursewareService!addCourseware.do")
                .setParam(param)
                .post();
    }

    /**
     * 请求添加课件接口添加纯文字课件
     * @return 请求返回状态
     */
    public Request doPaintextRequest() {
        publicParam();
        plaintextParam();
        return new Http()
                .setUrl("/sss/service/coursewareService!addCourseware.do")
                .setParam(param)
                .post();
    }

    /**
     * 请求添加课件接口添加图文课件
     * @return 请求返回状态
     */
    public Request doImagetextRequest() {
        publicParam();
        imagetextParam();
        return new Http()
                .setUrl("/sss/service/coursewareService!addCourseware.do")
                .setParam(param)
                .post();
    }

    /**
     * 请求添加课件接口添加图片课件
     * @return 请求返回状态
     */
    public Request doImageRequest() {
        publicParam();
        imageParam();
        return new Http()
                .setUrl("/sss/service/coursewareService!addCourseware.do")
                .setParam(param)
                .post();
    }

    /**
     * 请求添加课件接口添加视频课件
     * @return 请求返回状态
     */
    public Request doVideoRequest() {
        publicParam();
        videoParam();
        return new Http()
                .setUrl("/sss/service/coursewareService!addCourseware.do")
                .setParam(param)
                .post();
    }


    /**
     * 公共添加参数
     */
    private void publicParam() {

        //课件模板
        param.put("vo.bean.courseWareTemplate",2);

        //排序号
        param.put("vo.bean.sort",1);
    }


    /**
     * 纯文字添加参数
     */
    private void plaintextParam() {
        //课件名称时间戳
        param.put("vo.bean.courseWareName", "批量纯文字课件");

        //课件类型
        param.put("vo.bean.courseWareType",1);

        //课件图片
        param.put("vo.bean.resourseUrl","");

        //课件描述
        param.put("vo.bean.couresWareDiscription","<p>　　许飞朦朦胧胧的有了意识，然而首先感觉到的，就是胸腔一片剧痛、痛彻心扉，且剧痛中、还带有某种空荡荡的麻木感。</p>\n" +
                "<p>　　这是中枪了、还造成了严重的空腔。</p>\n" +
                "<p>　　许飞心头凛然，这样的伤势，就算立即抢救也很难幸存。想到自己正在荒凉的地方执行任务，许飞心头升起明悟——自己，怕是要死了。</p>\n" +
                "<p>　　或许是回光返照吧，许飞这样认为，只觉得意识渐渐清晰起来，听到了周围的谈话：</p>\n" +
                "<p>　　一个沙哑无力的声音：“黄伟，没想到你竟然对队友下黑手……呼呼……还是背后下手！老子太特么的小看你了！”</p>\n" +
                "<p>　　黄伟怪笑，却也咳嗽无力：“查尔斯，老子才不是什么飞龙冒险团的人，老子是寒霜之星冒险团的人！</p>\n" +
                "<p>　　老子不爽你很久了！”</p>\n" +
                "<p>　　黄伟？查尔斯？自己有这样的队友吗？许飞心头迷茫，情况似乎不对。</p>\n" +
                "<p>　　“什么…你…咳咳…你竟然是卧底！团里还有其他人吧！”查尔斯惊讶的说话都不连贯，重伤濒死的他，已经进入弥留之际。</p>\n" +
                "<p>　　“所以，你可以瞑目了！”黄伟说完，随后就是一声枪响，查尔斯闷哼一声，临死前伸手拉住‘已经死了的’许飞，断断续续的说道：“许飞…我…对不起你，先前不该拉你挡枪，没想到……我也逃不过……”</p>\n" +
                "<p>　　话未说完，查尔斯已经悄无声息；温热的血水浸湿了许飞的右手，查尔斯手中的枪，竟也刚好落在许飞右手边。</p>\n" +
                "<p>　　旁边，黄伟却在得意的奸笑：“精神力种源，这竟然就是传说中、不可能存在的精神力种源！也是传说中，唯一可以与别的种源共存的、成为第二种源的！”</p>\n" +
                "<p>　　奸笑声打开了许飞的记忆，一点点杂乱的记忆冲了出来：</p>\n" +
                "<p>　　数万年前，科技巅峰时代轰然崩塌，地球文明进入了超能力时代、或者说另类进化时代；这时代的核心，就是“种源”——一种四维结晶、或者说四维晶体。</p>\n" +
                "<p>　　‘种源’的全称是“物种与物质之本源属性”。物质之所以有不同，是因为都有不同的“属性”：高矮长短黑白冷热等等。</p>\n" +
                "<p>　　而‘属性’，就是四维科技中的‘第四维’。包罗万象。</p>\n" +
                "<p>　　科技巅峰时代，将这种‘属性’提取出来，制造了‘种源’，人们开始了野心勃勃的造神计划、永生计划。</p>\n" +
                "<p>　　结果种源有点强大，新生的‘神’们又私心作祟，反过头结束了科技时代，那是一场漫长而惨烈的战争。</p>\n" +
                "<p>　　总结起来一句话：世界被高科技玩坏了，连高科技时代自己都崩溃了。</p>\n" +
                "<p>　　掌控了种源的强者，可以变身为钢铁之躯，无坚不摧；可以变成宇宙战舰，纵横驰骋；可以控制病毒，掌控亿万生命的生死；也可以化身火焰，焚烧天地；甚至可以化作光芒，转瞬亿万里……</p>\n" +
                "<p>　　至于自己吗，竟然穿越了，依然叫‘许飞’、十八岁；属于机修班的小小学徒，来知名的A级冒险团、飞龙冒险团。</p>\n" +
                "<p>　　而造成许飞现在处境的，是：</p>\n" +
                "<p>　　飞龙冒险团接了一个探险的任务，受一个女孩儿雇佣来此探险；据说，那女孩儿得到什么确定的消息，说这里有宝贝。</p>\n" +
                "<p>　　但是来到这里后，却遭遇了另一个A级冒险团、寒霜之星冒险团的伏击。飞龙冒险团的飞船第一时间就趴窝了。</p>\n" +
                "<p>　　原来，消息就是寒霜之星冒险团释放的，其目的，就是要生擒那个女孩儿——那消息本身就是一个阴谋。消息是真的，这里真的有宝贝——就在许飞面前，但阴谋也不是假的。</p>\n" +
                "<p>　　激战中，许飞等‘学徒’被打散；最后许飞、黄伟、查尔斯三人阴差阳错的来到这个密室；在这里，他们三个发现了一个绝对的宝贝——精神力种源！</p>\n" +
                "<p>　　之后的事情不用说，黄伟最先下手，查尔斯最灵敏，将“许飞”拖过来做了‘防弹小棉袄’。</p>\n" +
                "<p>　　忽然，又一个强烈的记忆浮现——吞噬种源，可以救命！可以救命！！可以救命！！！</p>\n" +
                "<p>　　许飞刚想到这里，脚边有轻微的爬动声传来。是那个黄伟，他也受了重伤，在与查尔斯的战斗中受伤了。</p>\n" +
                "<p>　　许飞微微睁开眼睛，小心的向脚边看去；很好，这里很是昏暗，只有脚边有一些光亮——那是精神力种源的方向。</p>\n" +
                "<p>　　查尔斯侧躺在许飞旁边，已经失去呼吸；那个黄伟正在向前爬去，血水将地面上厚厚的泥沙浸润出一道道难看的疤痕。</p>\n" +
                "<p>　　许飞眯着眼睛，小心的摸起查尔斯的枪，简单的动作却扯动了伤口，痛苦几乎要撕裂灵魂；但当冰冷的枪支入手，许飞却仿佛瞬间找回了生命，熟悉的感觉油然而生。</p>\n" +
                "<p>　　右手缓缓贴在地面上，对准了黄伟。可因为两人都趴在地上，枪口只能瞄准黄伟的腿部，无法瞄准要害。</p>\n" +
                "<p>　　许飞有点焦急。</p>\n" +
                "<p>　　忽然，黄伟似乎有所感应，也或许是想看看自己的杰作吧，总之他停了下来，慢慢的、艰难的回头。</p>\n" +
                "<p>　　下一刻，黄伟的瞳孔猛然瞪大，他，看到了黑洞洞的枪口，而使用这把枪的，却是一个本该已死之人！</p>\n" +
                "<p>　　“不！”黄伟大叫一声，向旁边翻滚，却来不及了。一颗子弹从黄伟右眼钻入、击穿了右侧太阳穴，恐惧、痛苦和绝望让黄伟疯狂。黄伟左眼闪过一丝狠色，猛然开启了手臂上的定位器。</p>\n" +
                "<p>　　几乎同时，许飞第二枪来到，正中黄伟的眉心。黄伟死了，但脸上却挂着诡异的笑容。</p>\n" +
                "<p>　　可此时的许飞一心只想着‘精神力种源’：只要吞下去，自己就有活下去的希望！</p>\n" +
                "<p>　　艰难的弯过身，胸口的痛苦，让许飞几乎窒息；肺部被破坏，呼吸更加困难。每一口呼吸，都是一次千刀万剐的酷刑，灵魂都在抽搐。</p>\n" +
                "<p>　　那是一个被淡淡灯光照亮的真空罩、放置于半米高度、大约一米直径的黑色金属柱上。其中有一颗变幻的‘晶体’，拇指大小，有如梦幻一般美丽。</p>\n" +
                "<p>　　血液大量的流失，许飞意识已经有些模糊，生命、已经进入倒计时。</p>\n" +
                "<p>　　不行，快，要快，和死神抢时间！</p>\n" +
                "<p>　　许飞一咬牙，猛然从地上跪了起来，向前方爬去。胸口有血水在滴落，一滴滴打湿了地面。</p>\n" +
                "<p>　　近了，近了，就在眼前……</p>\n" +
                "<p>　　那是一颗梦幻般的晶体，似乎并没有固定的形状，有如梦幻一般变幻，点点彩光从表面闪过，那是比钻石都璀璨的光芒。‘晶体’下方，似乎还有一本日记本。</p>\n" +
                "<p>　　许飞想要仔细观察，可是眼前却出现了重影，世界开始模糊。</p>\n" +
                "<p>　　时间不多了！许飞心头闪过明悟。艰难的抬起手枪，对准了好似玻璃一样的真空罩……</p>\n" +
                "<p>　　镚儿~~~</p>\n" +
                "<p>　　一声脆响，‘玻璃罩’丝毫无损。</p>\n" +
                "<p>　　见鬼的高科技！许飞心头咒骂，关键时候竟然来了这样一着，这是死神的玩笑吗。</p>\n" +
                "<p>　　不，要冷静，越是危机的时候越要冷静，冷静了效率才会更高。</p>\n" +
                "<p>　　许飞狠心咬破了舌尖，激烈的疼痛刺激肾上腺激素略微上升，让意识稍微清晰一些。</p>\n" +
                "<p>　　对，这样的真空罩必然有开关。</p>\n" +
                "<p>　　身体已经有些飘忽，似乎感受不到痛苦，死神即将降临。</p>\n" +
                "<p>　　许飞眯着眼睛，让有些扩散的瞳孔尽量清晰，双手也在仔细的摸索……找到了，一个已经有些锈蚀的按钮出现在许飞的眼前，许飞用仅有的力量按下，按钮仅仅只是轻微晃动一下，就按不下去了。</p>\n" +
                "<p>　　“生锈了！我擦！”许飞抬起手枪，对着按钮就是一枪。</p>\n" +
                "<p>　　子弹打开了开关，但手枪也被子弹给弹飞，许飞右手有些发麻。</p>\n" +
                "<p>　　真空罩缓缓打开，许飞不及等待，左手直接拿出‘精神力种源’，不管不顾的一口吞下。</p>\n" +
                "<p>　　种源看上去如同钻石，但放入口中却感觉不到实体，似乎蓬松的棉花糖一样，瞬间就融化、消失在口腔中。</p>\n" +
                "<p>　　随即一股难以描述的力量爆发，好像海浪一样冲击着许飞的身体，强大的力量促了进许飞伤口的愈合。</p>\n" +
                "<p>　　“呼……”许飞松了一口气，精神十分疲惫、昏昏欲睡。这一连串的事情，几乎耗尽了许飞所有的精气神。</p>\n" +
                "<p>　　但此时许飞并没有发现，随着真空罩开启，一个古老的开关似乎也被打开，一点点寒气从真空罩内逸散，点点森冷的气息开始弥漫。</p>\n" +
                "<p>　　几乎同时，密室外面传来脚步声，有一个说话的声音传来：“应该就是这里了，黄伟的定位器信号就在这里。大家找找入口。”</p>\n" +
                "<p>　　定位器？</p>\n" +
                "<p>　　昏昏欲睡的许飞豁然瞪大眼睛，看向黄伟的尸体，赫然发现他的左臂上有一个微弱的灯光在闪烁。</p>\n" +
                "<p>　　“混蛋！”许飞心脏都在收缩！</p>");
    }

    /**
     * 图文添加参数
     */
    private void imagetextParam() {
        //课件名称时间戳
        param.put("vo.bean.courseWareName", "批量图文课件");

        //课件类型
        param.put("vo.bean.courseWareType",1);

        //课件图片
        param.put("vo.bean.resourseUrl",images.get((int)(Math.random()*imageCount)));

        //课件描述
        param.put("vo.bean.couresWareDiscription","<p>　　午后的阳光透过透明的玻璃，落入城堡的餐厅。玻璃上少许五彩让阳光折射出艳丽的色彩，美不胜收。</p>\n" +
                "<p>　　遗憾的是，无论什么样的阳光，都没办法让穿越者们的脸色变得好看起来。</p>\n" +
                "<p>　　相反，因为阳光灿烂，更将他们面前餐盘里食物的光泽倒映在了脸上，让他们一个个脸色碧绿，宛若传说中的“当然是原谅她啦”爱好者。</p>\n" +
                "<p>　　在一个个精致宛若工艺品的银餐盘里面，是一盘盘翠绿的，青草。</p>\n" +
                "<p>　　由拥有多个专业认证，精通中日法三国厨艺，甚至在米其林二星店当过掌勺的名厨出品。经过若干道工序，尽可能去除了原本的青涩，让口感丰富而细腻，足以充当食物的。</p>\n" +
                "<p>　　野草。</p>\n" +
                "<p>　　坐在餐桌前的穿越者们模样各不相同，有金发碧眼的，有黑发黑眸的，有尖耳朵的，有大胡子的，还有不少兽头人身的。</p>\n" +
                "<p>　　但他们的表情却几乎都一样，一个个被眼前餐盘里面的草映得绿油油，宛若撕碎了苦胆，把胆汁都涂在了脸上。</p>\n" +
                "<p>　　“大家快吃啊。”坐在餐桌主席上，高大帅气尖耳朵，却有着一双破坏形象的狼眼睛的青年干笑了两声，说，“这可是我精心制作的，绝对代表了我的水平。我的水平，大家还不放心吗？”</p>\n" +
                "<p>　　“莽穿地球”公会的成员们当然信服他们会长的厨艺水平，尤其是那些参加过当初线下聚会的成员们，那次“三余无梦生”会长亲自下厨，做了一桌酒菜，吃得他们几乎连舌头都吞了下去。</p>\n" +
                "<p>　　但是，就算会长的厨艺再好，又能拿这些杂草怎么样呢？</p>\n" +
                "<p>　　最终，还是一个有着黑白相间熊猫脸的壮汉先开吃，他沉默不语，用筷子夹起一大把青草，送进了嘴里，用力地咀嚼了几下，然后咕噜一声咽了下去。</p>\n" +
                "<p>　　从他开始，穿越者们一个个唉声叹气，将大把大把的青草送进了嘴里。</p>\n" +
                "<p>　　他们沉默不语，只是默默咀嚼，然后忍着如何神厨妙手也没办法完全去除的青涩感觉，将炖烂了的野草努力咽下去。</p>\n" +
                "<p>　　一个背后长着翅膀的少女大约是想要缓和一下气氛，笑着说：“你们看，其实这个跟炒韭菜很类似耶。”</p>\n" +
                "<p>　　她夹起一筷子青草，向大家展示：“记得我妈当初第一次下厨，炒的韭菜差不多就是这个样子。”</p>\n" +
                "<p>　　说着，她开心地笑着，将那一筷子青草送进了嘴里，用力地嚼。</p>\n" +
                "<p>　　“唔唔，会长你手艺真棒，很好吃的呢……比我妈当初炒的韭菜还好吃！”</p>\n" +
                "<p>　　但嚼着嚼着，她就停了下来，垂下头，捂住了脸。</p>\n" +
                "<p>　　和刚才那活力十足的话音截然相反的低沉呜咽从她的指缝里面传了出来。</p>\n" +
                "<p>　　“我想回家……”</p>\n" +
                "<p>　　坐在她身边，上半身是人而下半身是马的高大女人俯身抱住她的肩膀，却说不出什么安慰的话语来。</p>\n" +
                "<p>　　餐厅的气氛越发的低沉，许多人都在低声的哭泣。</p>\n" +
                "<p>　　他们都是生活在和平国度里面的普通游戏玩家，莫名其妙穿越到游戏世界里面，虽然种族和职业还在，等级装备什么的却全泡了汤，变成一群只剩１级的准白板，这些天龟缩在公会城堡里面哪里都不敢去，靠着读书打扫之类日常训练缓慢地积攒经验值，为了节约仓库里面所剩无几的粮食，甚至已经混到了吃草的地步……</p>\n" +
                "<p>　　他们真的受够了！</p>\n" +
                "<p>　　吃第一顿草的时候，很多人都还能够互相笑着打趣。第二顿的时候，笑声就渐渐地少了。后来他们不断抗议，但抗议声也一样渐渐地少了，最后只剩下死气沉沉。</p>\n" +
                "<p>　　到今天，他们已经吃了快十顿草。</p>\n" +
                "<p>　　一个穿着红袍的半精灵法师脸色狰狞，用筷子戳着自己餐盘里面的青草，宛如是什么生死仇敌一般。但筷子却一滑，掉到了地上。</p>\n" +
                "<p>　　他没有去捡筷子，惨笑起来：“我打拼多年，吃苦受累，好歹攒下了三四百万的身家。山珍海味不敢说，可起码好酒好菜是从来不缺的。想不到竟然落到要吃草……哈哈……哈哈……哈哈哈哈……”</p>\n" +
                "<p>　　他的笑声越发的低沉，渐渐如同疯狂一般，却也没有爆发，只是趴在桌子上，笑声越来越低沉，最终变成了哭声。</p>\n" +
                "<p>　　穿越者们再也受不了，终于哭成了一片。</p>\n" +
                "<p>　　在这片悲惨戚戚的气氛之中，那个最早开口吃草的熊猫脸大汉一言不发地将自己餐盘里面的焯青草吃得干干净净，连汤水都喝完了，然后拿起桌上的头盔，站了起来。</p>\n" +
                "<p>　　坐在他附近的会长三余立刻就注意到了，问：“熊猫，你要去哪里？”</p>\n" +
                "<p>　　“打猎。”大汉戴上头盔，沉声说。</p>\n" +
                "<p>　　“现在出门太危险！太危险了！”三余叹了口气，劝道，“至少再等几天吧，等升到五级左右，再大家一起出门。现在就做一些日常训练，攒攒经验算了。我知道大家都不愿意吃草，可是……再忍忍吧。”</p>\n" +
                "<p>　　“我不在乎吃草。”头盔下传来被称作“熊猫”的大汉的声音，“但这样下去，有人会发疯。”</p>\n" +
                "<p>　　三余顿时噎住，沉默不语。</p>\n" +
                "<p>　　他当然看得出来，公会里面一些性格脆弱的人，已经到了发疯的边缘。</p>\n" +
                "<p>　　像哭泣的“一鹰二富士三茄子”或者“织梦者真残念”这种，其实还算是好的。哭得出来，就表示他们还能够调节自己的情绪。最怕的是那些铁青着脸，颤抖着咀嚼青草，却怎么也咽不下去的……就像熊猫说的，他们只怕真的快要疯了。</p>\n" +
                "<p>　　一片沉默中，另外几个人站起来，大声说：“我们跟你一起去！”</p>\n" +
                "<p>　　熊猫并没有答应，却反问：“你们杀过什么？”</p>\n" +
                "<p>　　几人纷纷愣住，片刻之后，一个人嗫嗫嚅嚅地说：“我……拍过苍蝇……”</p>\n" +
                "<p>　　熊猫摇头。</p>\n" +
                "<p>　　“我解剖过青蛙。”</p>\n" +
                "<p>　　熊猫摇头。</p>\n" +
                "<p>　　“我……我杀过鸡！”一个人似乎很下了几分决心，大声说。</p>\n" +
                "<p>　　熊猫还是摇头。</p>\n" +
                "<p>　　这时，一个脑袋狰狞凶恶充满了爬行类风格，一看就让人感觉不是善类的高个子走出来，走到他的身边：“我是驴友，野外生存的时候杀过蛇和野鸡，跟朋友一起猎过野猪——俺寻思着，应该能帮上忙。”</p>\n" +
                "<p>　　熊猫拍拍他的肩膀，终于点了头。</p>\n" +
                "<p>　　两人正要离开，一个穿着超级厚重铠甲的大汉追了上来：“我虽然什么都没杀过，但我这身铠甲起码能当盾牌用吧！”</p>\n" +
                "<p>　　紧接着，一个身材瘦削却充满力量，脸色严肃的中年也追上来：“我参加过射箭俱乐部。”</p>\n" +
                "<p>　　他们才刚刚出门，之前那个哭泣的有翅膀的少女已经追了上来：“带我去！我能帮你们寻找猎物！”</p>\n" +
                "<p>　　又走了一阵，那个红袍的半精灵法师也追了出来：“妈蛋！老子丢了这么大的脸，不找回场子的话，还不如死了算了！”</p>\n" +
                "<p>　　最后，当他们走到门口时，伴随着马蹄声，扛着巨大长枪的半人马女战士追了上来。</p>\n" +
                "<p>　　“其实我什么都不会，但如果你们猎到什么的话，总应该需要一匹驮运猎物的马。”</p>\n" +
                "<p>　　午后的灿烂阳光下，一行七人并没有多说什么，在为首的熊猫壮汉带领下，默默地走出了城堡大门。 </p>");
    }

    /**
     * 图片课件添加参数
     */
    private void imageParam() {
        //课件名称时间戳
        param.put("vo.bean.courseWareName", "批量图片课件");

        //课件类型
        param.put("vo.bean.courseWareType",2);

        //课件图片
        param.put("imgeAndDisc[0].resourceUrl",images.get((int)(Math.random()*imageCount)));
        param.put("imgeAndDisc[1].resourceUrl",images.get((int)(Math.random()*imageCount)));
        param.put("imgeAndDisc[2].resourceUrl",images.get((int)(Math.random()*imageCount)));
        param.put("imgeAndDisc[3].resourceUrl",images.get((int)(Math.random()*imageCount)));
        param.put("imgeAndDisc[4].resourceUrl",images.get((int)(Math.random()*imageCount)));
        param.put("imgeAndDisc[5].resourceUrl",images.get((int)(Math.random()*imageCount)));

        //课件描述
        param.put("vo.bean.couresWareDiscription","<p>这个是图片课件</p>");

    }

    /**
     * 视频课件添加参数
     */
    private void videoParam() {
        //课件名称时间戳
        param.put("vo.bean.courseWareName", "批量视频课件");

        //课件类型
        param.put("vo.bean.courseWareType",3);

        //课件描述
        param.put("vo.bean.couresWareDiscription","<p>这个是视频课件</p>");

        //课件视频
        param.put("vo.bean.resourseUrl",videos[(int)(Math.random()*15)]);
    }

}
