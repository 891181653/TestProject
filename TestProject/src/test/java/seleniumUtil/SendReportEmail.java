package seleniumUtil;

import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.HtmlEmail;

import com.sun.mail.imap.protocol.MailboxInfo;

public class SendReportEmail {
	public void sendMial() {
		HtmlEmail htmlEmail = new HtmlEmail();
		htmlEmail.setHostName("smtp.163.com");
		htmlEmail.setAuthentication("a891181653@163.com", "zaqxsw123");
		try {
			// 设置发送邮箱
			htmlEmail.setFrom("a891181653@163.com");
			// 添加要放送的邮箱
			htmlEmail.addTo("891181653@qq.com");
			// 添加标题
			htmlEmail.setSubject("selenium 测试报告");
			// 添加内容
			htmlEmail.setHtmlMsg("<a href=\"\">测试报告");
			htmlEmail.setCharset("UTF-8");
		} catch (EmailException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		EmailAttachment emailAttachment = new EmailAttachment();
		emailAttachment.setName("测试报告SendReportEmail.html");
		emailAttachment.setPath("D:\\ssh\\TestProject\\TestProject\\2019年-10月-11日-15时13分31秒report.html");
		emailAttachment.setDescription(EmailAttachment.ATTACHMENT);
		try {
			htmlEmail.attach(emailAttachment);
			htmlEmail.send();
		} catch (EmailException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
          System.out.println("发送完毕");
	}

}
