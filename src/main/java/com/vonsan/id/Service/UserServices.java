package com.vonsan.id.Service;

import com.vonsan.id.DTO.UserResponse;
import com.vonsan.id.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.server.ResponseStatusException;
import org.thymeleaf.TemplateEngine;
import org.springframework.http.HttpStatus;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import org.thymeleaf.context.Context;

public abstract class UserServices implements UserService {
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private TemplateEngine templateEngine;
    public final void emailRegisterUser(User user){
        MimeMessage mimeMessage  = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "UTF-8");

        Context context = new Context();
        context.setVariable("user",user);

        try {
            helper.setTo(user.getEmail());
            helper.setSubject("Successful Registration at VonsanID");
            String htmlContent = templateEngine.process("MailMessage", context);
            helper.setText(htmlContent, true);
            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_GATEWAY,
                    "Gagal mengirim email");
        }
    }
}
