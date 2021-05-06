package pl.pjatk.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class AppConfig {


    @Bean
    public MySimplePojo mySimplePojo() {
        System.out.println("z normalnej klasy");
        return new MySimplePojo(10,"heh");

    }
    @Bean
    public List<String> defaultData(){
        return List.of("1","2","3","4","5");
    }
}
