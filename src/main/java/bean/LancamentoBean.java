package bean;

import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import dao.LancamentoDAO;
import models.entities.Lancamento;
import models.enums.TipoLancamento;

@ManagedBean
public class LancamentoBean {
	private Lancamento lancamento = new Lancamento();
	
	public Lancamento getLancamento() {
		return lancamento;
	}

	public void setLancamento(Lancamento lancamento) {
		this.lancamento = lancamento;
	}	
	
	public void create() {
		LancamentoDAO.salvar(lancamento);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Salvo com sucesso"));
	}
	
	public void info() {
		List<Lancamento> lancamentos = LancamentoDAO.listar();
		double totalDespesa = 0;
		double totalReceita = 0;
		for(Lancamento lancamento: lancamentos) {
			if(lancamento.getTipo().equals(TipoLancamento.DESPESA)) {
				totalDespesa += lancamento.getValor();
			} else {
				totalReceita += lancamento.getValor();
			}
		}
		
		double totalLancamento = totalReceita - totalDespesa;
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Suas despesas: " + totalDespesa +
        " | Suas receitas: " + totalReceita +
        " | Seu saldo: " + totalLancamento));
    }
		
	public List<Lancamento> listar(){
		return LancamentoDAO.listar();
	}
	
	public void excluir(Lancamento l){
		LancamentoDAO.excluir(l);;
	}
}
