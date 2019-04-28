package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import entities.ItemBiblioteca;
import filters.ItemBibliotecaFilter;
import impl.ItemBibliotecaServiceImpl;
import service.ItemBibliotecaService;
import service.ServiceDacException;

@RequestScoped
@ManagedBean
public class ManageItemBiblioteca extends AbstractBean {
	private static final long serialVersionUID = 1L;
	private ItemBibliotecaService itemBibliotecaService = new ItemBibliotecaServiceImpl();
	private List<ItemBiblioteca> item;
	private ItemBibliotecaFilter itemBibliotecaFilter;

	public List<ItemBiblioteca> getItem() {
		return item;
	}

	public ItemBibliotecaFilter getItemBibliotecaFilter() {
		return itemBibliotecaFilter;
	}

	public void setItemBibliotecaFilter(ItemBibliotecaFilter itemBibliotecaFilter) {
		this.itemBibliotecaFilter = itemBibliotecaFilter;
	}
	@PostConstruct
	public void init() {
		limpar();
		filtrar();
	}

	public String filtrar() {
		try {
			item = itemBibliotecaService.findBy(getItemBibliotecaFilter());
		} catch (ServiceDacException e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}
		return null;
	}

	public String limpar() {
		this.itemBibliotecaFilter = new ItemBibliotecaFilter();
		return null;
	}


}
