package beans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.ItemBiblioteca;
import impl.ItemBibliotecaServiceImpl;
import service.ItemBibliotecaService;
import service.ServiceDacException;


@ViewScoped
@ManagedBean
public class ItemBibliotecaConverterBean extends AbstractBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6407136907389313210L;

	private List<ItemBiblioteca> item;
	
	private ItemBiblioteca selectedItemBiblioteca;

	private ItemBibliotecaService itemService = new ItemBibliotecaServiceImpl();

	@PostConstruct
	public void init() {
		try {
			item = itemService.getAll();
		} catch (ServiceDacException e) {
			reportarMensagemDeErro(e.getMessage());
		}
	}

	public List<ItemBiblioteca> getItem() {
		return item;
	}
	
	public ItemBiblioteca getSelectedItemBiblioteca() {
		return selectedItemBiblioteca;
	}
	
	public void setSelectedItemBiblioteca(ItemBiblioteca selectedItemBiblioteca) {
		this.selectedItemBiblioteca = selectedItemBiblioteca;
	}

}



