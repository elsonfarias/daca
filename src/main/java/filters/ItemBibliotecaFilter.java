package filters;

import java.util.Date;

import entities.Tipo;

public class ItemBibliotecaFilter implements Filter {
	private static final long serialVersionUID = 1L;
	private String titulo;

	private String editora;

	private String iSBN;

	private Integer minimoPaginas;

	private Integer maximoPaginas;

	private Date dataPublicacaoMin;

	private Date dataPublicacaoMax;

	private Tipo tipo;

	public ItemBibliotecaFilter() {

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getiSBN() {
		return iSBN;
	}

	public void setiSBN(String iSBN) {
		this.iSBN = iSBN;
	}

	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}

	public Integer getMinimoPaginas() {
		return minimoPaginas;
	}

	public void setMinimoPaginas(Integer minimoPaginas) {
		this.minimoPaginas = minimoPaginas;
	}

	public Integer getMaximoPaginas() {
		return maximoPaginas;
	}

	public void setMaximoPaginas(Integer maximoPaginas) {
		this.maximoPaginas = maximoPaginas;
	}

	public Date getDataPublicacaoMin() {
		return dataPublicacaoMin;
	}

	public void setDataPublicacaoMin(Date dataPublicacaoMin) {
		this.dataPublicacaoMin = dataPublicacaoMin;
	}

	public Date getDataPublicacaoMax() {
		return dataPublicacaoMax;
	}

	public void setDataPublicacaoMax(Date dataPublicacaoMax) {
		this.dataPublicacaoMax = dataPublicacaoMax;
	}

	public boolean isEmpty() {
		if (this.editora != null && !this.editora.trim().isEmpty()) {
			return false;
		}
		if (this.titulo != null && !this.titulo.trim().isEmpty()) {
			return false;
		}

		if (this.dataPublicacaoMin != null) {
			return false;
		}

		if (this.dataPublicacaoMax != null) {
			return false;
		}
		if (this.tipo != null) {
			return false;
		}
		if (this.iSBN != null) {
			return false;
		}
		if (this.minimoPaginas != null) {
			return false;
		}
		if (this.maximoPaginas != null) {
			return false;
		}

		return true;
	}

	@Override
	public String toString() {
		return "ItemBibliotecaFilter [titulo=" + titulo + ", editora=" + editora + ", iSBN=" + iSBN + ", minimoPaginas="
				+ minimoPaginas + ", maximoPaginas=" + maximoPaginas + ", dataPublicacaoMin=" + dataPublicacaoMin
				+ ", dataPublicacaoMax=" + dataPublicacaoMax + ", tipo=" + tipo + "]";
	}
}
// public void validate() throws ServiceDacException {
// if (this.birthdayRangeBegin != null && this.birthdayRangeEnd != null) {
// if (this.birthdayRangeBegin.after(this.birthdayRangeEnd)) {
// throw new ServiceDacException("'Birthday range begin' should be before
// 'birthday range end'!");
// }
