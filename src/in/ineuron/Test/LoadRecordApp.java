package in.ineuron.Test;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import in.ineuron.Model.Student;
import in.ineuron.Util.HibernateUtil;

public class LoadRecordApp {

	public static void main(String[] args) throws IOException {
		
		Session session=null;
		int id=1;
		
		try {
		session=HibernateUtil.geSession();
		
		if(session !=null)
		{
			Student student=session.load(Student.class, id);
			if(student!=null)
			System.out.println("STUDENT ID IS      ::"+student.getSid());
			
			System.in.read();
			
			System.out.println("STUDENT NAME IS    ::"+student.getSname());
			System.out.println("STUDENT AGE IS     ::"+student.getSage());
			System.out.println("STUDENT ADDRESS IS ::"+student.getSaddress());
		}
			else
			{
				System.out.println("Record not found for given id");
			
		}
		}catch (HibernateException e) {
			e.printStackTrace();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			
			}
			
		
			HibernateUtil.closeSession(session);
			HibernateUtil.closeSessionFactory();
		}

	}


