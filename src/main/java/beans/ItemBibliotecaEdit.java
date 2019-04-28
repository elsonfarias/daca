package beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import entities.ItemBiblioteca;
import entities.Tipo;
import impl.ItemBibliotecaServiceImpl;
import service.ItemBibliotecaService;
import service.ServiceDacException;

@ViewScoped
@ManagedBean
public class ItemBibliotecaEdit extends AbstractBean {
	private static final long serialVersionUID = -7779155604704232174L;
	private ItemBibliotecaService itemService = new ItemBibliotecaServiceImpl();
	private ItemBiblioteca item;

	public void init() {
		try {
			if (item == null) {
				// Criando
				item = new ItemBiblioteca();
			} else {
				// Editando
				if (isEdicaoItemBiblioteca()) {
					itemService.update(item);
				} else {
					itemService.save(item);
				}
			}
		} catch (ServiceDacException e) {
			reportarMensagemDeErro(e.getMessage());
		}
	}

	public String saveItemBiblioteca() {
		try {
			if (isEdicaoItemBiblioteca()) {
				itemService.update(item);
			} else {
				itemService.save(item);
			}
		} catch (ServiceDacException e) {
			reportarMensagemDeErro(e.getMessage());
			return null;
		}

		reportarMensagemDeSucesso("Item Biblioteca '" + item.getTitulo() + "' saved");

		return EnderecoPaginas.PAGINA_PRINCIPAL_ITEMBIBLIOTECA;
	}

	public ItemBiblioteca getItem() {
		return item;
	}

	public void setItem(ItemBiblioteca item) {
		this.item = item;
	}

	public boolean isEdicaoItemBiblioteca() {
		return item != null && item.getId() != null;
	}

	public boolean isLivro() {
		return item != null && item.getTipo() == Tipo.LIVRO;
	}

	public boolean isLivroDeBolso() {
		return item != null && item.getTipo() == Tipo.LIVRO_BOLSO;
	}

	public boolean isCapaDura() {
		return item != null && item.getTipo() == Tipo.CAPA_DURA;
	}

	public boolean isEbook() {
		return item != null && item.getTipo() == Tipo.EBOOK;
	}

	public boolean isRevista() {
		return item != null && item.getTipo() == Tipo.REVISTA;
	}

	public boolean isPeriódico() {
		return item != null && item.getTipo() == Tipo.PERIODICO;
	}
}
