package br.com.ivanfsilva.libraryapi.service.impl;

import br.com.ivanfsilva.libraryapi.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    @Value("${application.mail.default-rement}")
    private String rement;

    private final JavaMailSender javaMailSender;

    @Override
    public void sendMails(String message, List<String> mailsList) {
        String[] mails = mailsList.toArray(new String[mailsList.size()]);

        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(rement);
        mailMessage.setSubject("Livro com emprestimo atrasado.");
        mailMessage.setText(message);

        mailMessage.setTo(mails);

        javaMailSender.send(mailMessage);

    }

    @Override
    public void sendMails(List<String> mailsList) {

    }
}
