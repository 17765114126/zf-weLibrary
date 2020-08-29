package com.example.springboot.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @ClassName EmailTool
 * @Author zhaofu
 * @Date 2020/8/24
 * @Version V1.0
 **/
@Component
public class EmailTool {

    protected static final Logger logger = LoggerFactory.getLogger(EmailTool.class);

    public static final String ZSZT = "";

    @Resource
    private JavaMailSender mailSender;

    public void sendEmail(Map<String, String> map) {

        String to = map.get("E_TO");

        String cc = map.get("E_CC");

        String bcc = map.get("E_BCC");

        String subject = map.get("E_SUBJECT");

        String text = map.get("E_CONTENT");

        if (to != null) {

            try {
                SimpleMailMessage message = new SimpleMailMessage();

                message.setFrom(ZSZT);

                message.setTo(to.split(","));

                if (cc != null) {
                    message.setCc(cc.split(","));
                }
                if (bcc != null) {
                    message.setBcc(bcc.split(","));
                }

                message.setSubject(subject);
                message.setText(text);
                mailSender.send(message);
            } catch (Exception e) {
                logger.error("EmailTool ---> sendEmail() --- error");
                e.printStackTrace();
            }
        } else {
            logger.warn("EmailTool sendEmail() -- to == null");
        }
    }

}
