package com.pig.dead;

import com.pig.dead.constants.EncryptConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.util.ObjectUtils;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;

@Slf4j
@SpringBootApplication
public class DeadApplication {

    public static void main(String[] args) {
        SpringApplication.run(DeadApplication.class, args);
    }

    private String interviewQuestion(String path) throws URISyntaxException {
        if(ObjectUtils.isEmpty(path)){
            return EncryptConstant.UN_KNOW;
        }
        URL resource = ClassLoader.getSystemResource(path);
        File file = new File(resource.toURI());
        if(!file.exists()){
            return EncryptConstant.UN_KNOW;
        }
        if (file.isDirectory()) {
            String[] list = file.list();
            if (!ObjectUtils.isEmpty(list)) {
                int random = (int) Math.abs(Math.floor(Math.random() * list.length));
                return interviewQuestion(path.concat("/").concat(list[random]));
            }
            return EncryptConstant.UN_KNOW;
        }
        StringBuilder sb = new StringBuilder();
        try (InputStream in = new FileInputStream(file);
             InputStreamReader is = new InputStreamReader(in, StandardCharsets.UTF_8)) {
            int len;
            while ((len = is.read()) != -1) {
                sb.append((char) len);
            }
        } catch (IOException e) {
            log.error("出现异常!kfc crazy thursday!");
        }
        return sb.toString();
    }

    @Bean
    CommandLineRunner commandLineRunner() {
        return args -> System.out.println(interviewQuestion("static/exp/java"));
    }

}
