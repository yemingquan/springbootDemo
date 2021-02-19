import com.example.springBootDemo.config.parameters.enums.ErrorEnum;
import com.example.springBootDemo.model.Student;
import com.example.springBootDemo.model.Student2;
import com.example.springBootDemo.util.SystemUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.util.StopWatch;

import java.util.*;

/**
 * @所属模块
 * @描述
 * @创建人 xiaoYe
 * @创建时间 2020/6/2 15:29
 * @备注
 */
@Slf4j
public class mainTest {


    public static void main(String[] args) throws Exception {
        log.info(ErrorEnum.getMsg("000"));


//        SystemUtil.showSystemInfo();
        System.exit(-1);
//        stopWathTest();


//      流水号 = 系统+时间+随机数
        log.info(UUID.randomUUID().toString());
        log.info(FastDateFormat.getInstance("yyyyMMddHHmmssSSS").format(new Date()));
//        与其运行环境相连接的类
//        Runtime r = Runtime.getRuntime();
//        r.exec("calc");// 打开计算器，没有p.destroy();
//        r.exec("mspaint");// 打开画板，没有p.destroy();
//        Thread.sleep(5000);// 程序暂停执行5秒
//
//        System.out.println("run方法的打印:"+Thread.currentThread().getName());

//        三目运算符
//        String value = "1";
//        value = value == null ? "null" :"not null";
//        log.info(value);

//        String[] arr = ",,,,,".split(SystemConstant.DEFAULT_CSV_SPLITY_REGEX);
//        log.info(""+arr.length);

//      去掉数字
//        String data = "2020-6-15 15:46:08".replaceAll("[^0-9]","");
//        String time = data.substring(0,7);
//        log.info(data);
//        log.info(time);

//        遍历map
//        Map<String,Long> expires = new HashMap<>();
//        expires.put("1",1111l);
//        expires.put("2",1111l);
//        expires.put(null,1111l);
//        expires.put("3",null);
//        expires.put(null,null);
//        Optional.ofNullable(expires).ifPresent(expiresMap -> System.err.println(expiresMap));

//        生成代码的
//        CreateService c = new CreateService();
//        c.createFile();

//          数组快速构建
//        Student s = new Student();
//        s.setId(1l);
//        List<Student> list = Lists.newArrayList(s,s,s);
//        log.info(list.toString());
//        快速判断List是否为空 null 0为false
//        Boolean flag = CollectionUtils.isNotEmpty(list);
//        log.info(""+flag);

//      map 快速构建 节省枚举部分
//        Map<String,Object> body =  Maps.newConcurrentMap();
//        body.put("1","1");
//        body.put("2","2");
//       log.info(body.toString());

//        PageInfo pageInfo = new PageInfo(list);
//        pageInfo.setList(list.stream().map(mainTest::getStudent).collect(Collectors.toList()));
//        log.info("pageInfo"+pageInfo.getList());

//        IntStream.range(1,8).forEach(System.out::println);
//        DoubleStream.of(1.23,1.23,.23).forEach(System.out::println);



//        List<String> aList = new ArrayList<>();
//        aList.add("南京");
//        aList.add("大学");
//        aList.add("仙林校区");
//        aList.add("仙林大学城");
//        aList.add("中山北路");
//
//        Map<String, Integer> map =
//                aList.stream().collect(Collectors.toMap(Function.identity(), String::length));
//        System.out.println(map);
//        TODO easyPoi
    }

    /**
     * 计时器测试
     * @throws InterruptedException
     */
    public static void stopWathTest() throws InterruptedException {
        StopWatch sw = new StopWatch("最终统计");

        sw.start("task1");
        Thread.sleep(1000);
        sw.stop();
        sw.start("AAA");
        Thread.sleep(2000);
        sw.stop();

//       子任务用信息
        log.info("******************子任务用信息******************");
        log.info("getLastTaskName：[{}]",sw.getLastTaskName());
        log.info("getLastTaskTimeMillis：[{}]秒",sw.getLastTaskTimeMillis());

//       统计用信息
        log.info("******************统计信息******************");
        log.info("getTaskCount：[{}]",sw.getTaskCount());
        log.info("getTotalTimeMillis：[{}]",sw.getTotalTimeMillis());

//      汇报用信息
        log.info("******************汇报用信息******************");
        log.info(sw.prettyPrint());

    }

    private static Student2 getStudent(Student student) {
        return Student2
                .builder()
                .id(student.getId())
                .name("name")
                .build();
    }
}
