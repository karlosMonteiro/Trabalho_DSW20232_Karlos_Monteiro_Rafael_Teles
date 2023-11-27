import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import models.entities.Lancamento;
import models.enums.TipoLancamento;
import utils.JPAUtil;

public class start {
 public static void main(String[] args) {
         EntityManager manager = JPAUtil.criarEntityManager();
         EntityTransaction tran = manager.getTransaction();
         tran.begin();

        Lancamento lan = new  Lancamento(0, "Teste", 0, TipoLancamento.DESPESA, new Date());
        manager.persist(lan);
        tran.commit();
        System.out.println(lan.getId());
}
}