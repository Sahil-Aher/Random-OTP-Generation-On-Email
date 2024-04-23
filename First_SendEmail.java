import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

public class First_SendEmail
{
   public static void main(String[] args)
   {
      Scanner sc=new Scanner(System.in);
      System.out.println("Enter mail id:-");
      String to=sc.nextLine();

      final String username = "projectsystem21@gmail.com";
      final String password = "ujhrlmnhbgbosgyk";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", "smtp.gmail.com");
      props.put("mail.smtp.port", "25");

      Session session = Session.getInstance
                                      (props,new javax.mail.Authenticator()
    {
       protected PasswordAuthentication getPasswordAuthentication()
       { 
           return new PasswordAuthentication(username, password);
	   }
   });

      try
      {
	 	  Message message = new MimeMessage(session);

	  	  message.setFrom(new InternetAddress(username));

	  	  message.setRecipients(Message.RecipientType.TO,
	  	                                            InternetAddress.parse(to));

	  	  message.setSubject("OTP For Login");
	  	  Random ra= new Random();
	  	  String otp = ra.nextInt(9)+"";
	  	  otp+= ra.nextInt(9)+"";
	  	  otp+= ra.nextInt(9)+"";
	  	  otp+= ra.nextInt(9)+"";
	  			  
	  	 message.setText("OTP code=" +otp);

	  	  Transport.send(message);

	  	  System.out.println("Sent message successfully....");
	  	 System.out.println("Enter OTP=");
	  	 String val= sc.nextLine();
	  	 if(val.equals(otp))
	  	 System.out.println("Valid User");
	  	 else
	     System.out.println("Invalid User");
      }
      catch (MessagingException e)
      {
         throw new RuntimeException(e);
      }
   }
}






