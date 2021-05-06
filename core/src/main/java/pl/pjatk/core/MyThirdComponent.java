package pl.pjatk.core;

import org.springframework.stereotype.Component;

@Component
public class MyThirdComponent {
    public MyThirdComponent(MyFirstComponent myFirstComponent, MySecoundComponent mySecoundComponent) {
        myFirstComponent.printHelloFromMethod();
        mySecoundComponent.printFromSecound();
    }
}
