package com.book.manager;

import com.book.manager.entity.Book;
import com.book.manager.entity.Users;
import com.book.manager.service.BookService;
import com.book.manager.service.DIDService;
import com.book.manager.service.UserService;
import com.webank.weid.protocol.base.WeIdAuthentication;
import com.webank.weid.protocol.base.WeIdPrivateKey;
import com.webank.weid.rpc.WeIdService;
import com.webank.weid.service.impl.WeIdServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;


@SpringBootTest
public class ManagerApplicationTests {

	@Autowired
	private BookService bookService;

	@Autowired
	private UserService userService;


	@Test
	public void contextLoads() {
		for (int i = 0; i < 15; i++) {
			Book book = new Book();
			book.setIsbn("121312"+i);
			book.setAuthor("Jason"+i);
			book.setName("《高等数学必修》"+i);
			book.setPages(150+i);
			book.setPrice(15d+i);
			book.setPublish("北京邮电出版社分社"+i);
			book.setSize(i);
			book.setTranslate("翻译者"+i);
//			book.setType(0);
			book.setPublishTime(new Date());
			bookService.addBook(book);

			Users user = new Users();
			user.setSize(i);
			user.setAddress("北京街道"+i);
			user.setAvatar("avatar"+i+".jpg");
			user.setBirthday(new Date());
			user.setEmail("demo"+i+"@163.com");
			user.setIdentity(0);
			user.setIsAdmin(0);
			user.setNickname("admin"+i);
			user.setUsername("admin"+i);
			user.setPassword("123"+i);
			userService.addUser(user);
		}
	}
	@Test
	public void testGetDID(){
		WeIdService service = new WeIdServiceImpl();
		WeIdAuthentication weIdAuthentication = new WeIdAuthentication();
		weIdAuthentication.setWeId("did:weid:666:0x383e962f7ab8ed4a6e7173758e63f32a415c9be1");
		WeIdPrivateKey weIdPrivateKey = new WeIdPrivateKey();
		weIdPrivateKey.setPrivateKey("19091736990516714524288970013450212621475649300357507513418504949458995746142");
		weIdAuthentication.setWeIdPrivateKey(weIdPrivateKey);
		weIdAuthentication.setAuthenticationMethodId("did:weid:666:0x383e962f7ab8ed4a6e7173758e63f32a415c9be1#keys-75ad8301");
		System.out.println(service.getWeIdDocumentJson("did:weid:666:0x383e962f7ab8ed4a6e7173758e63f32a415c9be1"));
	}

}
