

import org.hibernate.Session;

import br.com.acolhimento.util.HibernateUtil;

public class HibernateUtilTest {
	public static void main(String[] args) {
		
		Session sessao = HibernateUtil.getFabricaSessoes().openSession();
		
		sessao.close();
		
	}
	
}
