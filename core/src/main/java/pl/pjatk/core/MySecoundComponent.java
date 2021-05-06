package pl.pjatk.core;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty("my.custom.property")
public class MySecoundComponent {





    public MySecoundComponent(MyFirstComponent myFirstComponent, @Value("${my.custom.property}") String message){

        myFirstComponent.printHelloFromMethod();
        System.out.println(message);


    }

    void printFromSecound(){
        System.out.println("dwa w trzecim");
    }
}