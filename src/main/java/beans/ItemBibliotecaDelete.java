package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.ItemBiblioteca;
import impl.ItemBibliotecaServiceImpl;
import service.ItemBibliotecaService;
import service.ServiceDacException;

@ViewScoped
@ManagedBean
public class ItemBibliotecaDelete extends AbstractBean {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4804260264032468336L;
	
	private ItemBiblioteca itemBiblioteca;
	
	private ItemBibliotecaService itemService = new ItemBibliotecaServiceImpl();

	public String delete() {
		try {
			itemService.delete(itemBiblioteca);
		} catch (ServiceDacException e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}

		reportarMensagemDeSucesso("ItemBiblioteca '" + itemBiblioteca.getTitulo() + "' deleted");

		return EnderecoPaginas.PAGINA_PRINCIPAL_ITEMBIBLIOTECA;
	}
		public ItemBiblioteca getItemBiblioteca() {
			return itemBiblioteca;
		}

		public void setItemBiblioteca(ItemBiblioteca itemBiblioteca) {
			this.itemBiblioteca = itemBiblioteca;
		}
	}