package pl.pjatk.core;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MyFirstComponent {

    public MyFirstComponent(MySimplePojo mySimplePojo, List<String> defaultData){
        System.out.println("siema");
        mySimplePojo.soutSomething();
        System.out.println(defaultData);
    }
    void printHelloFromMethod(){
        System.out.println("co tam");
    }
}
