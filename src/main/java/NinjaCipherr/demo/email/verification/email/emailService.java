package NinjaCipherr.demo.email.verification.email;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * emailService
 */
@Service
public class emailService implements emailSender {
  private JavaMailSender mailSender;

  public send(String to,String email){
  }
}
